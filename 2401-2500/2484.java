class Solution {
    private static final int M = 1_000_000_000 + 7;
    
    public int countPalindromes(String s) {
        int n = s.length();
        long totalCount = 0;
        
        // for palindromes of the form "cd.dc", we will check
        // every possible combination of "cd" from "00" to "99"
        for (char c = '0'; c <= '9'; c++) {
            for (char d = '0'; d <= '9'; d++) {
                
                // number of combinations of "cd." up to each index (inclusive)
                long[] startCount = new long[n];
                
                // number of combinations of "cd"
                long cBeforeD = 0;
                
                // number of "c"
                long cCount = 0;
                
                // scan forwards to populate startCount
                for (int i = 0; i < n; i++) {
                    startCount[i] = cBeforeD;
                    
                    // use multiple if instead of if/else for when c == d
                    char ch = s.charAt(i);
                    if (ch == d) {
                        cBeforeD += cCount;
                    }
                    if (ch == c) {
                        cCount++;
                    }
                }
                
                // reset counts
                cBeforeD = 0;
                cCount = 0;
                
                // scan backwards to update totalCount, stop at i == 3
                // because startCount counts the first 3 characters "cd."
                for (int i = n - 1; i >= 3; i--) {
                    char ch = s.charAt(i);
                    if (ch == d) {
                        cBeforeD += cCount;
                    }
                    if (ch == c) {
                        cCount++;
                    }
                    
                    // the update to totalCount is the number of combinations of "dc"
                    // encountered so far multiplied by the number of combinations
                    // of "cd." up to index i - 1
                    totalCount = (totalCount + cBeforeD * startCount[i - 1]) % M;
                }
            }
        }
        
        return (int)totalCount;
    }
}

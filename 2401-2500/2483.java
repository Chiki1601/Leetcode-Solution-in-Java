class Solution {
    public int bestClosingTime(String customers) {
        int[] prefixCountN = new int[customers.length() + 1];
        int[] suffixCountY = new int[customers.length() + 1];
        if (customers.charAt(0) == 'N') {
            prefixCountN[0] = 1;
        }
        if (customers.charAt(customers.length() - 1) == 'Y') {
            suffixCountY[customers.length() - 1] = 1;
        }
        for (int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);
            if (c == 'Y') {
                prefixCountN[i + 1] = prefixCountN[i];
            } else { 
                prefixCountN[i + 1] = prefixCountN[i] + 1;
            }
        }
        for (int i = customers.length(); i >= 1; i--) {
            char c = customers.charAt(i - 1);
            if (c == 'N') {
                suffixCountY[i - 1] = suffixCountY[i];
            } else { 
                suffixCountY[i - 1] = suffixCountY[i] + 1;
            }            
        }
        int minResult = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i <= customers.length(); i++) {
            int penalty = prefixCountN[i] + suffixCountY[i];
            if (minResult > penalty) {
                minIndex = i;
                minResult = penalty;
            }
        }
        return minIndex;
    }
}

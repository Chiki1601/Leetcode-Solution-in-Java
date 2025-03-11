class Solution {
    public int numberOfSubstrings(String s) { 
    int[] count = new int[3]; 
        int left = 0; 
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;

            
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += s.length() - i; // All substrings starting at left and ending at i or beyond are valid
                count[s.charAt(left) - 'a']--; // Decrement the count of the left character
                left++; 
            }
        }
        return result; 
    }
}

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> charToVal = new HashMap<>();
        for (int i = 0; i < vals.length; ++i) {
            charToVal.put(chars.charAt(i), vals[i]);
        }
        int maxCost = 0;
        for (int i = 0, maxCostSubstringEndingAtCur = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int v = charToVal.getOrDefault(c, c - 'a' + 1);
            maxCostSubstringEndingAtCur = Math.max(maxCostSubstringEndingAtCur + v, v);
            maxCost = Math.max(maxCost, maxCostSubstringEndingAtCur);
        }
        return maxCost;
    }
}

class Solution {
    public int longestSubsequence(int[] nums, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int max_length = 1;

        for (int num : nums) {
            if (dp.containsKey(num - difference)) {
                dp.put(num, dp.get(num - difference) + 1);
            } else {
                dp.put(num, 1);
            }

            max_length = Math.max(max_length, dp.get(num));
        }

        return max_length;
    }
}

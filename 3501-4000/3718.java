class Solution {
    public int missingMultiple(int[] nums, int k) {
        for (int i = k;; i += k) {
            int target = i;
            if (Arrays.stream(nums).noneMatch(x -> x == target))
                return i;
        }
    }
}

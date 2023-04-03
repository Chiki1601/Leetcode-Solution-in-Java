class Solution {
        public int minNumber(int[] nums1, int[] nums2) {
        Set<Integer> s1 = getHashSet(nums1), s2 = getHashSet(nums2);
        s1.retainAll(s2);
        if (!s1.isEmpty()) {
            return new TreeSet<>(s1).first();
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = nums1[0], b = nums2[0];
        return Math.min(a, b) * 10 + Math.max(a, b);
    }
    private HashSet<Integer> getHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }
}

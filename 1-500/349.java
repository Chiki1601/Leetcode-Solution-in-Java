class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for(int n : nums1) {
            set1.add(n);
        }
        for(int n : nums2) {
            if(set1.contains(n)) {
                set2.add(n);
            }
        }
        int[] res = new int[set2.size()];
        int i = 0;
        for(int n: set2) {
            res[i++] = n;
        }
        return res;
    }
}

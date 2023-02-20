class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> ls = new ArrayList<>();
        int n = nums1.length;
        BitSet bs = new BitSet(n);
        long sum = 0;
        for(int i = 0;i < n;i++){
            sum += 1L * nums2[i];
            if(nums1[i] == 1) bs.set(i);
        }
        for(var q:queries){
            if(q[0] == 1){
                bs.flip(q[1],q[2] + 1);
            }
            else if(q[0] == 2){
                sum += 1L * q[1] * bs.cardinality();
            }
            else ls.add(sum);
        }
        long ans[] = new long[ls.size()];
        for(int i = 0;i < ans.length;i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}

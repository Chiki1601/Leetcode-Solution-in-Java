public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        int i;
        int value;
        for(i = 0; i < nums1.length; i++) {
            value = hMap.containsKey(nums1[i]) ? hMap.get(nums1[i])+1 : 1;
            hMap.put(nums1[i], value);
        }
        int size = nums1.length > nums2.length ? nums2.length : nums1.length;
        int[] intersection = new int[size];
        int j = 0;
        for(i = 0; i < nums2.length; i++) {
            value = hMap.containsKey(nums2[i]) ? hMap.get(nums2[i]) : 0; 
            if (value > 0) {
               intersection[j++] = nums2[i];
               hMap.put(nums2[i], value-1);
            }
        }
        int[] result = new int[j];
        for (i = 0; i < j; i++) {
            result[i] = intersection[i];
        }
        return result;
    }
}

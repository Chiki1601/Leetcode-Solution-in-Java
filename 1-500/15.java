public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
	    if (nums == null || nums.length == 0) {
	        return rst;
	    }
	    
	    Arrays.sort(nums);
	    HashSet<String> set = new HashSet<String>();
	    //use old target to check duplicates. instead of set.
	    for (int i = 0; i < nums.length - 2; i++) {
	        int target = 0 - nums[i];
	        int start = i + 1;
	        int end = nums.length - 1;
	        
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        while (start < end) {
	            if (nums[start] + nums[end] == target &&  
	                !set.contains(nums[i] + "," + nums[start] + "," + nums[end])) {
	                list.add(nums[i]);
	                list.add(nums[start]);
	                list.add(nums[end]);
	                rst.add(list);
	                set.add(nums[i] + "," + nums[start] + "," + nums[end]);
	                list = new ArrayList<Integer>();
	                start++;
	                end--;
	            } else if (nums[start] + nums[end] < target) {
	                start++;
	            } else {
	                end--;
	            }
	        }//end while        
	    }
	    
	    return rst;
    }
}

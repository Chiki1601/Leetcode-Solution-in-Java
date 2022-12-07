class Solution {
    public int countSubarrays(int[] nums, int k) {
        // find the position of k
        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                pos = i;
                break;
            }
        }
    
        int res = 1;    
        HashMap<Integer, Integer> diffToCount = new HashMap<>();
        
        int prevDiff = 0;
        for (int i = pos - 1; i >= 0; i--) {
            int currDiff = -1;
            if (nums[i] > k) {
                currDiff = prevDiff + 1;
            } else {
                currDiff = prevDiff - 1;
            }
            if (currDiff == 0 || currDiff == 1) {
                res++;
            }
            
            diffToCount.put(currDiff, diffToCount.getOrDefault(currDiff, 0) + 1);
            prevDiff = currDiff;
        }
        
        prevDiff = 0;
        for (int i = pos + 1; i < nums.length; i++) {
            int currDiff = -1;
            if (nums[i] > k) {
                currDiff = prevDiff + 1;
            } else {
                currDiff = prevDiff - 1;
            }
            if (currDiff == 0 || currDiff == 1) {
                res++;
            }
            
            res += diffToCount.getOrDefault(-currDiff, 0);
            res += diffToCount.getOrDefault(1 - currDiff, 0);
            prevDiff = currDiff;
        }
        return res;
    }
}

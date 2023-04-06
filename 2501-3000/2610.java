class Solution {
       public List<List<Integer>> findMatrix(int[] nums) {
        int[] arr = new int[201];
        int max=0;
        for(int i=0; i<nums.length; i++){
        	arr[nums[i]]++;
        	max = Math.max(max, arr[nums[i]]);
        }
        List<List<Integer>> res = new ArrayList();
        int i=1;
        while(i<=max){
        	List<Integer> list = new ArrayList<Integer>();
        	for(int j=0; j<201; j++){
        		if(arr[j]>=i){
        			list.add(j);
        		}
        	}
        	if(list.size()>0){
        		res.add(list);
        	}
        	i++;
        }
        return res;
    }
}

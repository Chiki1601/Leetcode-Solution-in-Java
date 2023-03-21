class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        f(0,nums,res,new ArrayList<>(),k);
        return res.size();
    }
    public void f(int ind,int[] nums,List<List<Integer>> res,List<Integer> ds,int k){
        if(ind==nums.length){
            if(ds.size()>0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(!(ds.contains(nums[ind]-k) )){
            ds.add(nums[ind]);
            f(ind+1,nums,res,ds,k);    
            ds.remove(ds.size()-1);
        }
        f(ind+1,nums,res,ds,k);
    }
}

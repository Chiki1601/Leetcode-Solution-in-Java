class Solution {
    public int singleNumber(int[] nums) {
        
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:nums){
            if(!set.add(i)) 
                set.remove(i);
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}

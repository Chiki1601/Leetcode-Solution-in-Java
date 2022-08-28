public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList());
        
        Arrays.sort(num);
        
        for(int i : num){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> sub : result){
                List<Integer> inner = new ArrayList<Integer>(sub);
                inner.add(i);
                if(!result.contains(inner))
                    temp.add(inner);
            }
            result.addAll(temp);
        }
        return result;
    }
}

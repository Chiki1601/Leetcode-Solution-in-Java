class Solution {
    public int subarraysDivByK(int[] A, int k) 
    {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int i = 0; int count = 0;
        while(i<A.length)
        {
            sum += A[i];
            int div = ((sum % k) + k) % k;
            map.put(div , map.getOrDefault(div,0) + 1);
            i++;
        }
        for(int n : map.values())
        {
            count += (n * (n - 1))/2;
        }
        
        return count;
    }
}

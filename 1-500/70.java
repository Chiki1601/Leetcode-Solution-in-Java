class Solution {
    
    int [] cache = new int[46];
    
    public int climbStairs(int n) {
        
        if(n < 0) return 0;
        
        if(n == 0) return 1;
        
        int val = cache[n];
        
        if(val != 0)
            return val;
        
        val = climbStairs(n - 1) + climbStairs(n - 2);
        
        cache[n] = val;
        
        return val;
    }
}

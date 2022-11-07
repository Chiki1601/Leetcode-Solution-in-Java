class Solution {
    Long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);  
        Arrays.sort(factory,(a,b)->(a[0]-b[0])); 
        dp = new Long[robot.size()+1][factory.length+1];
        return solve(robot,factory,0,0);
    }
    
    public long solve(List<Integer> list,int[][] arr,int i,int j){
        
        if(i>=list.size()) return 0L;  
        if(j>=arr.length) return Long.MAX_VALUE; 
        
        if(dp[i][j]!=null) return dp[i][j]; 
        
        long x = 0;
        long res = solve(list,arr,i,j+1); 

        for(int k = i;k<list.size() && k-i+1<=arr[j][1];k++){
            x += Math.abs(list.get(k)-arr[j][0]);
            long p = solve(list,arr,k+1,j+1);
		
            if(p!=Long.MAX_VALUE){
                res = Math.min(res,x+p);
            }
        }
        
        return dp[i][j] = res;
    }
    
}

class Solution {
    int n=(int)(1e6);
    int[] spf=new int[n+1];
    public void sieve(){
        for(int i=1;i<=n;i++){
            spf[i]=i;
        }
        for(int j=2;j*j<=n;j++){
            if(spf[j]==j){
                for(int k=j*j;k<=n;k+=j){
                    if(spf[k]==k){
                        spf[k]=j;
                    }
                }
            }
        }
    }
    public int findValidSplit(int[] nums) {
        sieve();
        int[] lastfactorindex=new int[n+1];
        for(int i=0;i<nums.length;i++){
            int x=nums[i];
            List<Integer> pf=new ArrayList<>();
            while(x!=1){
                int z=spf[x];
                while(x%z==0)
                    x/=z;
                pf.add(z);  
            }
            for(int distfactors:pf){
                lastfactorindex[distfactors]=i;
            }
        }
        int splitind=0;
        int i=0;
        for(;i<=splitind;i++){
            int x=nums[i];
            List<Integer> pf=new ArrayList<>();
            while(x!=1){
                int z=spf[x];
                while(x%z==0)
                    x/=z;
                pf.add(z);  
            }
            for(int distfactors:pf){
                splitind=Math.max(splitind,lastfactorindex[distfactors]);
            }
        }
        if(splitind==nums.length-1) return -1;
        return splitind;       
    }
}

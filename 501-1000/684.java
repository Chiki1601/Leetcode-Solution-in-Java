class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    Map<String, Integer> pos = new HashMap<>();
    boolean[] isVis;
    int max=-1;
    void dfs(int i, int parent){
        isVis[i]=true;
        for(int j : adj.get(i)){
            if(!isVis[j])
                dfs(j, i);
            else if(j!=parent && pos.containsKey(i+","+j) && max<pos.get(i+","+j)){
                max=pos.get(i+","+j);
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length, i=0;
        for(; i<=n; i++){
            adj.add(new ArrayList<Integer>());
        }
        i=0;
        for(int[] ii:edges){
            pos.put(ii[0]+","+ii[1],i++);
            adj.get(ii[0]).add(ii[1]);
            adj.get(ii[1]).add(ii[0]);
        }
        for(i=1; i<n+1; i++){
            isVis=new boolean[n+1];
            dfs(i,-1);
        }
        return edges[max];
    }
}

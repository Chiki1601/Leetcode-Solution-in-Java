class Solution {
    private int[] parent;
    private int[] root;
    private int[] size;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        parent = new int[N + 1];
        root = new int[N + 1];
        int[] ans1 = null;
        int[] ans2 = null;
        for(int i = 1; i < root.length; i++) root[i] = i;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(parent[v] > 0){ // current node has two parents, we need to delete one of them.
                ans1 = new int[]{parent[v], v};
                ans2 = new int[]{u, v};
                edge[0] = edge[1] = -1;
            }
            parent[v] = u;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(u < 0 || v < 0) continue;
            int p = find(u);
            int q = find(v);
            if(p == q){ // u & v create a cycle.
                return ans1 == null ? edge: ans1;
            }
            root[p] = q;
        }
        return ans2;
    }
    private int find(int node){
        if(node != root[node]){
            root[node] = find(root[node]);
        }
        return root[node];
    }
}

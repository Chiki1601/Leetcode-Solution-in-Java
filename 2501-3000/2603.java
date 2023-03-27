class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length; 
        Set<Integer>[] tree = new HashSet[n]; 
        for (int i = 0; i < n; ++i) tree[i] = new HashSet(); 
        for (var e : edges) {
            tree[e[0]].add(e[1]); 
            tree[e[1]].add(e[0]); 
        }
        Queue<Integer> leaf = new LinkedList(); 
        for (int i = 0; i < n; ++i) {
            int u = i; 
            while (tree[u].size() == 1 && coins[u] == 0) {
                int v = tree[u].iterator().next(); 
                tree[u].remove(v); 
                tree[v].remove(u); 
                u = v; 
            }
            if (tree[u].size() == 1) leaf.add(u); 
        }
        for (int j = 0; j < 2; ++j) {
            for (int sz = leaf.size(); sz > 0; --sz) {
                int u = leaf.poll(); 
                if (tree[u].size() == 1) {
                    int v = tree[u].iterator().next(); 
                    tree[u].remove(v); 
                    tree[v].remove(u); 
                    if (tree[v].size() == 1) leaf.add(v); 
                }
            }
        }
        int ans = 0; 
        for (int i = 0; i < n; ++i) ans += tree[i].size(); 
        return ans; 
    }
}

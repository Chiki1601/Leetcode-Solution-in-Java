class Solution {
    Map<Integer, List<Integer>> map;
    public int magnificentSets(int n, int[][] edges) {
        map = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        // adjacency list
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        // get all components as Graph can be disconnected
        List<List<Integer>> components = getComponents(n);
        
        int ans = 0;
        /*
            - Take each component and get max groups can be formed from that component
            - return -1 if you can't form groups from any one of the components
        */
        for(List<Integer> component : components) {
            int groups = -1;
            for(int node : component) {
                groups = Math.max(groups, find(node, n));
            }
            if(groups == -1)
                return -1;
            ans += groups;
        }
        return ans;
    }
    
    private List<List<Integer>> getComponents(int n) {
        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                ans.add(visit(i, new ArrayList<>(), visited));
            }
        }
        return ans;
    }
    
    private List<Integer> visit(int cur, List<Integer> nodes, boolean[] visited) {
        visited[cur] = true;
        nodes.add(cur);
        for(int next : map.get(cur)) {
            // skip if you have already visited this node
            if(visited[next]) continue;
            visit(next, nodes, visited);
        }
        return nodes;
    }
    
    private int find(int node, int n) {
        int[] group = new int[n + 1];
        Arrays.fill(group, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int groups = 0;
        while(!queue.isEmpty()) {
            int k = queue.size();
            // store nodes in set to avoid duplicates
            Set<Integer> set = new HashSet<>();
            while(k-- > 0) {
                int cur = queue.poll();
                // this case occurs when 2 nodes in the same level are connected
                // so, return -1
                if(group[cur] != -1) return -1;
                group[cur] = groups;
                for(int next : map.get(cur)) {
                    if(group[next] == -1) {
                        set.add(next);
                    }
                }
            }
            queue.addAll(set);
            groups++;
        }
        return groups;
    }
}

class Solution {
           private static final int MX = Integer.MAX_VALUE; 
    public int findShortestCycle(int n, int[][] edges) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            g.computeIfAbsent(e[0], s -> new HashSet<>()).add(e[1]);
            g.computeIfAbsent(e[1], s -> new HashSet<>()).add(e[0]);
        }
        int shortest = MX;
        for (int i = 0; i < n; ++i) {
            int[] dist = new int[n], parent = new int[n];
            Arrays.fill(dist, MX);
            Arrays.fill(parent, -1);
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            dist[i] = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int kid : g.getOrDefault(node, Collections.emptySet())) {
                    if (dist[kid] == MX) {
                        dist[kid] = dist[node] + 1;
                        parent[kid] = node;
                        q.offer(kid);
                    }else if (parent[kid] != node && parent[node] != kid) {
                        shortest = Math.min(shortest, dist[kid] + dist[node] + 1);
                    }
                }
            }
        }
        return shortest == MX ? -1 : shortest;
    }
}

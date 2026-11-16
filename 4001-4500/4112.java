class Solution {
    public long maxScore(int[] parent, int[] op, int[] score) {
        int n = parent.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            children.get(parent[i]).add(i);
        }
        
        List<Integer> order = new ArrayList<>();
        order.add(0);
        for (int i = 0; i < order.size(); i++) {
            int u = order.get(i);
            for (int v : children.get(u)) {
                order.add(v);
            }
        }
        
        long[] dp = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int u = order.get(i);
            if (children.get(u).isEmpty()) {
                dp[u] = score[u];
                continue;
            }
            long totalSum = 0;
            long minChild = Long.MAX_VALUE;
            for (int v : children.get(u)) {
                totalSum += dp[v];
                if (dp[v] < minChild) {
                    minChild = dp[v];
                }
            }
            if (op[u] == 1) {
                dp[u] = score[u] + totalSum - minChild;
            } else {
                dp[u] = score[u] + totalSum - Math.min(0, minChild);
            }
        }
        return dp[0];
    }
}

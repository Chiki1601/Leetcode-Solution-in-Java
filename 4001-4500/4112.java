class Solution {
    public int maxScore(int[] parent, int[] op, int[] score) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);

        }
        int[] order = new int[n];

        int head = 0, tail = 0;

        order[tail++] = 0;
        while (head < tail) {
            int u = order[head++];
            for (int v : children[u]) {
                order[tail++] = v;
            }
        }

        long[] dp = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            if (children[u].isEmpty()) {
                dp[u] = score[u];
                continue;
            }
            long c_sum = 0;
            long c_dp = Long.MAX_VALUE;

            for (int v : children[u]) {
                c_sum=c_sum+dp[v];
                if(dp[v]<c_dp)
                {
                    c_dp=dp[v];
                }
            }

            if (op[u] == 1) {
                dp[u] = score[u] + c_sum - c_dp;
            } else {
                dp[u] = score[u] + c_sum - Math.min(0L, c_dp);
            }
        }
        return (int) dp[0];
    }
}

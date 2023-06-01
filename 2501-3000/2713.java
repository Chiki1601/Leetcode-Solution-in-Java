class Solution {
    public int maxIncreasingCells(int[][] mat) {
        final int m = mat.length, n = mat[0].length;
        int[] r = new int[m], c = new int[n];
        Map<Integer, List<int[]>> vmap = new HashMap<>();
        int[][] temp = new int[m][n];
        Set<Integer> s = new TreeSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                vmap.computeIfAbsent(-mat[i][j], k->new ArrayList<>()).add(new int[]{i,j});
                s.add(-mat[i][j]);
            }
            
        }
        for (Integer x : s) {
            for (int[] v : vmap.get(x)) {
                temp[v[0]][v[1]] = Math.max(r[v[0]], c[v[1]]) + 1;
            }
            for (int[] v : vmap.get(x)) {
                r[v[0]] = Math.max(r[v[0]], temp[v[0]][v[1]]);
                c[v[1]] = Math.max(c[v[1]], temp[v[0]][v[1]]);
            }   
        }
        int ans = Integer.MIN_VALUE;
        for (int x : r) {
            ans = Math.max(ans, x);
        }
        for (int x : c) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}

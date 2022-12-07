
class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road: roads) {
            int a = road[0];
            int b = road[1];
            int dist = road[2];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(new int[] {b, dist});
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(new int[] {a, dist});
        }
        Set<Integer> curCities = new HashSet<>();
        curCities.add(1);
        Set<Integer> seen = new HashSet<>();
        seen.add(1);
        int res = Integer.MAX_VALUE;
        while (!curCities.isEmpty()) {
            Set<Integer> nextCities = new HashSet<>();
            for (int curCity: curCities) {
                for (int[] next: graph.get(curCity)) {
                    int nextCity = next[0];
                    int dist = next[1];
                    if (!seen.contains(nextCity)) {
                        nextCities.add(nextCity);
                        res = Math.min(res, dist);
                    }
                }
            }
            for (int curCity: curCities) {
                seen.add(curCity);
            }
            curCities = nextCities;
        }
        return res;
    }
}

class Solution {
    public long minCost(int[] A, int[] B) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int a : A)
            count.merge(a, 1, Integer::sum);
        for (int a : B)
            count.merge(a, -1, Integer::sum);
        List<Integer> swaps = new ArrayList<>();
        long res = 0, small = count.firstKey();
        for (int a : count.keySet()) {
            if (count.get(a) % 2 > 0) return -1;
            int v = Math.abs(count.get(a)) / 2;
            for (int i = 0; i < v; ++i)
                swaps.add(a);
        }
        for (int i = 0; i < swaps.size() / 2; ++i)
            res += Math.min(swaps.get(i), small * 2);
        return res;
    }
}

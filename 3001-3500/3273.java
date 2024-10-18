class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        for (int i = 0; i < n; ++i) {
            health[i] = (health[i] + power - 1) / power;
        }
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            indexes.add(i);
        }
        indexes.sort((i, j) -> {
            return Integer.compare(health[i] * damage[j], health[j] * damage[i]);
        });
        long res = 0;
        int curTime = 0;
        for (int i : indexes) {
            curTime += health[i];
            res += curTime * damage[i];
        }
        return res;
    }
}

class Solution {

    private static int mod1 = 1000000007;
    private static int mod2 = 1000000009;
    private static int base1, base2;

    public int longestCommonSubpath(int n, int[][] paths) {
        int ans = 0;
        int m = paths.length;
        int len = 1000005;
        Random random = new Random();
        base1 = random.nextInt(10000000 - 1000000 + 1) + 1000000;
        base2 = random.nextInt(10000000 - 1000000 + 1) + 1000000;
        System.out.println(base1 + " " + base2);
        for (int i = 0; i < m; i++)
            len = Math.min(len, paths[i].length);
        int l = 1, r = len;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(n, paths, mid)) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return ans;
    }

    private static boolean check(int n, int[][] arr, int len) {
        int m = arr.length;
        long mul1 = 1, mul2 = 1;
        for (int i = 1; i <= len; i++) {
            mul1 = mul1 * base1 % mod1;
            mul2 = mul2 * base2 % mod2;
        }
        Set<Long> s = new HashSet<>();
        for (int i = 0; i < m; i++) {
            long hash1 = 0, hash2 = 0;
            for (int j = 0; j < len; j++) {
                hash1 = (hash1 * base1 + arr[i][j]) % mod1;
                hash2 = (hash2 * base2 + arr[i][j]) % mod2;
            }
            Set<Long> t = new HashSet<>();
            long val = hash(hash1, hash2);
            if (i == 0 || s.contains(val))
                t.add(val);
            for (int j = len; j < arr[i].length; j++) {
                hash1 = ((hash1 * base1 % mod1 - (long) arr[i][j - len] * mul1 % mod1 + arr[i][j]) % mod1 + mod1) % mod1;
                hash2 = ((hash2 * base2 % mod2 - (long) arr[i][j - len] * mul2 % mod2 + arr[i][j]) % mod2 + mod2) % mod2;
                val = hash(hash1, hash2);
                if (i == 0 || s.contains(val))
                    t.add(val);
            }
            if (t.isEmpty())
                return false;
            s.clear();
            for (Long ss : t)
                s.add(ss);
        }
        return true;
    }

    private static long hash(long hash1, long hash2) {
        long val1 = String.valueOf(hash1).hashCode();
        long val2 = String.valueOf(hash2).hashCode();
        return val1 << 16 ^ val2;
    }
}

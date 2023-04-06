class Solution {
       public long makeSubKSumEqual(int[] arr, int k) {
        int gcd = gcd(arr.length, k);
        long minOps = 0;
        for (int i = 0; i < gcd; ++i) {
            minOps += getOperationsCount(arr, i, gcd);
        }
        return minOps;
    }
    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
    private long getOperationsCount(int[] arr, int start, int gap) {
        int n = arr.length, m = n / gap;
        long min = Long.MAX_VALUE, sum = 0, cur = 0;
        int[] a = new int[m];
        for (int i = start, k = 0; i < n; i += gap, ++k) {
            a[k] = arr[i];
            sum += a[k];
        }
        Arrays.sort(a);
        for (int i = 0; i < m; ++i) {
            min = Math.min(min, (1L * i * a[i] - cur) + ((sum - cur) - 1L * (m - i) * a[i]));
            cur += a[i];
        }
        return min;
    }
}

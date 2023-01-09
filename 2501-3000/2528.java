class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long left = 0, right = k;
        for (int x: stations)
            right += x;
        // v is the stations after adding
        long []v = new long[n];
        while (left <= right) {
            long x = (left + right) / 2;
            for (int i = 0; i < n; ++i) 
                v[i] = stations[i];
            // s means the power of city i
            // at first, it record the sum of v[0,r)
            long s = 0, use = 0;
            for (int i = 0; i < r; ++i) 
                s += v[i];
            for (int i = 0; i < n; ++i) {
                // add to t if needed
                int t = Math.min(n - 1, i + r);
                // update s
                // find a city should be added
                if (i + r < n) s += v[i + r];
                // find a city should be removed
                if (i - r > 0) s -= v[i - r - 1];
                // mising power stations
                long diff = Math.max(0, x - s);
                v[t] += diff;
                s += diff;
                use += diff;
            }
            if (use <= k) left = x + 1;
            else right = x - 1;
        }
        return right;
    }
}

import java.util.*;

class Solution {
    public long minMergeCost(int[][] lists) {

        // Required variable
        int[][] peldarquin = lists;

        int n = peldarquin.length;
        int FULL = 1 << n;

        long[] dp = new long[FULL];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        int[] len = new int[FULL];
        int[] median = new int[FULL];

        // Precompute length
        for (int mask = 1; mask < FULL; mask++) {
            int lsb = mask & -mask;
            int i = Integer.numberOfTrailingZeros(lsb);
            len[mask] = len[mask ^ lsb] + peldarquin[i].length;
        }

        // Precompute median using binary search
        for (int mask = 1; mask < FULL; mask++) {
            int k = (len[mask] + 1) / 2; // left median
            median[mask] = findKth(peldarquin, mask, k);
        }

        // DP
        for (int mask = 1; mask < FULL; mask++) {

            if ((mask & (mask - 1)) == 0) {
                dp[mask] = 0;
                continue;
            }

            int first = Integer.numberOfTrailingZeros(mask);

            for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
                if ((sub & (1 << first)) == 0) continue;

                int other = mask ^ sub;
                if (other == 0) continue;

                long cost = dp[sub] + dp[other]
                        + len[sub] + len[other]
                        + Math.abs((long) median[sub] - median[other]);

                dp[mask] = Math.min(dp[mask], cost);
            }
        }

        return dp[FULL - 1];
    }

    // Find k-th smallest element in union of sorted arrays
    private int findKth(int[][] lists, int mask, int k) {
        int low = -1_000_000_000;
        int high = 1_000_000_000;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long count = 0;

            for (int i = 0; i < lists.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    count += upperBound(lists[i], mid);
                }
            }

            if (count < k) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    // upper bound (elements ≤ x)
    private int upperBound(int[] arr, int x) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] <= x) l = m + 1;
            else r = m;
        }
        return l;
    }
}

class Solution {
      public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> freqs = new HashMap<>();
        int maxFreq = 0;
        for (int n : nums) {
            n %= space;
            maxFreq = Math.max(maxFreq, freqs.merge(n, 1, Integer::sum));
        }
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (freqs.get(n % space) == maxFreq && min > n) {
                min = n;
            }
        }
        return min;
    }
    
}

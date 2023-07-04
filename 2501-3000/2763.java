class Solution {
  public int sumImbalanceNumbers(int[] nums) {
    int n = nums.length;
    int ans = 0;
    for (int i = 0; i < n; i++) {
        Set<Integer> s = new HashSet<>();
        int curr = 0;
        for (int j = i; j < n; j++) {
            int x = nums[j];
            if (s.contains(x)) {
                // do nothing
            } else if (s.contains(x - 1) && s.contains(x + 1)) {
                curr--;
            } else if (!s.contains(x - 1) && !s.contains(x + 1) && !s.isEmpty()) {
                curr++;
            }
            s.add(x);
            ans += curr;
        }
    }
    return ans;
}
}

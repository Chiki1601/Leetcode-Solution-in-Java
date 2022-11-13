class Solution {
    public int maxPalindromes(String s, int k) {
    int n = s.length(), last = Integer.MIN_VALUE, ans = 0;
    List<List<Integer>> intervals = new ArrayList();
    for (int center = 0; center < 2 * n; center++) {
        int left = center / 2;
        int right = left + center % 2;
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            if (right + 1 - left >= k) {
                intervals.add(new ArrayList<Integer>(Arrays.asList(left, right + 1)));
                break;
            }
            left--; right++;
        }
    }
    for (List<Integer> v: intervals) {
        if (v.get(0) >= last) {
            last = v.get(1);
            ans++;
        }
        else
            if (v.get(1) < last)
                last = v.get(1);
    }
    return ans;
}
}

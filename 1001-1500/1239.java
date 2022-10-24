class Solution {
    int ans = 0;

    public int maxLength(List<String> arr) {
        boolean[] flags = new boolean[26];
        dfs(0, arr, flags);
        return ans; 
    }

    void dfs(int p, List<String> arr, boolean[] flags) {
        for (int i = p; i < arr.size(); i++) {
            boolean[] prev_flags = flags.clone();
            boolean flag = true;
            for (int j = 0; j < arr.get(i).length(); j++) {
                if (flags[arr.get(i).charAt(j) - 'a'] == true) {
                    flag = false;
                    break;
                } else {
                    flags[arr.get(i).charAt(j) - 'a'] = true;
                }
            }
            if (flag == true) {
                int cur_ans = 0;
                for (int j = 0; j < flags.length; j++) {
                    if (flags[j] == true) {
                        cur_ans += 1;
                    }
                }
                ans = Math.max(ans, cur_ans);
                dfs(i + 1, arr, flags);
            }
            flags = prev_flags.clone();
        }
    }
}

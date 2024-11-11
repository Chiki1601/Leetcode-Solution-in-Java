class Solution {
    vector<int> cnt;
    int k;
    const int mod = 1e9 + 7;
    int dp[801][2][801];

public:
    int solve(const string& s, int i, bool tight, int setBits) {
        if (i == s.size()) return (tight || setBits == 0) ? 0 : cnt[setBits] < k;
        if(dp[i][tight][setBits] != -1) return dp[i][tight][setBits];
        
        if (tight) {
            if (s[i] == '0') return solve(s, i + 1, true, setBits);
            
            int res = solve(s, i + 1, true, setBits + 1);
            res = (res + solve(s, i + 1, false, setBits)) % mod;
            return dp[i][tight][setBits] = res;
        }
        
        int res = solve(s, i + 1, false, setBits + 1);
        res = (res + solve(s, i + 1, false, setBits)) % mod;
        return dp[i][tight][setBits] = res;
    }

    int countKReducibleNumbers(std::string s, int k) {
        this->k = k;
        this->cnt = std::vector<int>(801, 0);
        memset(dp, -1, sizeof(dp));
        for (int i = 2; i <= 800; i++) {
            int setBits = __builtin_popcount(i);
            cnt[i] = 1 + cnt[setBits];
        }        
        return solve(s, 0, true, 0);        
    }
};

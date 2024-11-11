class Solution {
public:
    int mod = 1000000007;

    int sumOfGoodSubsequences(vector<int>& nums) {
        map<int, int> cnt, sum;
        
        // Loop through all numbers in the nums array
        for (int i : nums) {
            // Update cnt[i] by considering subsequences from i-1, i, and i+1
            cnt[i] += (cnt[i - 1] + cnt[i + 1] + 1) % mod;
            cnt[i] %= mod;
            
            // Update sum[i] by considering subsequences from i-1, i, and i+1
            sum[i] += (sum[i - 1] + sum[i + 1]) % mod;
            sum[i] %= mod;
            
            // Add the contribution of the subsequences that end at i
            sum[i] += (long long)(cnt[i - 1] + cnt[i + 1] + 1) % mod * i % mod;
            sum[i] %= mod;
        }
        
        // Calculate the final result by summing all the values in sum
        int res = 0;
        for (auto &p : sum) {
            res += p.second;
            res %= mod;
        }
        
        return res;
    }
};

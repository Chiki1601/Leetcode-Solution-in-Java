class Solution {
public:
    struct Pair {
        int prev;
        int len;
        
        Pair(int prev, int len) : prev(prev), len(len) {}
    };
    int maximumJumps(vector<int>& nums, int target){
        int n = nums.size();
        vector<Pair> arr(n, Pair(-1, 0));
        arr[0] = Pair(0, 0);
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(abs(nums[i] - nums[j]) <= target){
                    if(arr[j].prev != -1 && arr[j].len + 1 > arr[i].len){
                        arr[i].prev = j;
                        arr[i].len = arr[j].len + 1;
                    }
                }
            }
        }
        
        return arr[n - 1].len > 0 ? arr[n - 1].len : -1;
    }
};

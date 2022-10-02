class Solution {
    
    int getSetBits(int num) {
        int ans = 0;
        for(int i = 0; i < 31; i++) {
            ans += ((1 << i & num) != 0 ? 1 : 0);
        }
        return ans;
    }
    
    int removeNBits(int num, int n) {
        for(int i = 30; i >= 0; i--) {
            if(n == 0) break;
            if((1 << i & num) != 0) {
                num = num ^ (1 << i);
                n--;
            }
        }
        return num;
    }
    
    int setNBits(int num, int n) {
        int ans = 0;
        for(int i = 0; i < 31; i++) {
            if(n == 0) break;
            if(((1 << i) & num) == 0) {
                ans = ans ^ (1 << i);
                n--;
            }
        }
        return ans;
    }
    
    public int minimizeXor(int num1, int num2) {
        int nm1 = getSetBits(num1);
        int nm2 = getSetBits(num2);
        int tmp1 = num1 - removeNBits(num1, nm2);
        if(nm2 > nm1) {
            tmp1 = num1 ^ setNBits(num1, nm2 - nm1);
        }
        return tmp1;
    }
}

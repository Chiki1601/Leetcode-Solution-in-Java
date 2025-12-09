class Solution {
    private boolean isPrime(int n) {
        if(n != 2 && n % 2 == 0) return false;
        for(int i = 3; i*i <= n; i += 2) {
            if(n % i == 0) return false;
        }
        return true;
    }
    public boolean completePrime(int num) {
        int y = 0, z = 1, x = num;
        while(x > 0) {
            y = z * (x % 10) + y;
            if(y == 1 || isPrime(y) == false) return false;
            if(x == 1 || isPrime(x) == false) return false;
            x /= 10; 
            z *= 10;
        }   
        return true;
    }
}

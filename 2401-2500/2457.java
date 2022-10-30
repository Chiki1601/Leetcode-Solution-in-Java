class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long result = 0, nCopy = n, beautyNumber = n;
        int digitSum = getDigitSum(nCopy), round = 1;
        if (digitSum <= target){
            return result;
        }

        while (digitSum > target){
            nCopy /= 10;
            beautyNumber = (long) ((nCopy + 1) * Math.pow(10, round));
            digitSum = getDigitSum(beautyNumber);
            round++;
        }
        return beautyNumber - n;
    }

    private static int getDigitSum(long n){
        int result = 0;
        while (n > 0){
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}

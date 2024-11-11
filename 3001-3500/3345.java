class Solution {
    public int calculateDigitProduct(int number) {
        int product = 1;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 0) {
                return 0;
            }
            product *= digit;
            number /= 10;
        }
        return product;
    }

    public int smallestNumber(int start, int divisor) {
        while (true) {
            if (calculateDigitProduct(start) % divisor == 0) {
                return start;
            }
            start++;
        }
    }
}

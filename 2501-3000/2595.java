class Solution {
    public int[] evenOddBit(int n) {
    return new int[] {Integer.bitCount(n & 0b0101010101), 
                      Integer.bitCount(n & 0b1010101010)};
}
}

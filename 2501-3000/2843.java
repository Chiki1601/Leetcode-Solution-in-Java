class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int num = low; num <= high; num++) {
            String s = Integer.toString(num);
            int len = s.length();
            if (len % 2 != 0)
                continue;
            int mid = len / 2;
            int leftSum = 0, rightSum = 0;
            for (int i = 0; i < mid; i++)
                leftSum += s.charAt(i) - '0';
            for (int i = mid; i < len; i++)
                rightSum += s.charAt(i) - '0';
            if (leftSum == rightSum)
                res++;
        }
        return res;
    }
}

class Solution {
       public int maximizeGreatness(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int a : A)
            if (a > A[res])
                res++;
        return res;
    }
}

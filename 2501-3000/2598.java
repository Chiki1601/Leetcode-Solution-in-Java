class Solution {
    public int findSmallestInteger(int[] A, int k) {
        int stop = 0, count[] = new int[k];
        for (int a : A)
            count[(a % k + k) % k]++;
        for (int i = 0; i < k; ++i)
            if (count[i] < count[stop])
                stop = i;
        return k * count[stop] + stop;
    }
}

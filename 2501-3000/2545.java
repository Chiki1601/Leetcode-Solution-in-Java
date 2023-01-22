class Solution {
    public int[][] sortTheStudents(int[][] A, int k) {
        Arrays.sort(A, (a, b) -> b[k] - a[k]);
        return A;
    }
}

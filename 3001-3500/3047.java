class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int ans = 0, n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            int[] firstRectBL = bottomLeft[i];
            int[] firstRectTR = topRight[i];
            for (int j = i + 1; j < n; j++) {
                int[] secondRectBL = bottomLeft[j];
                int[] secondRectTR = topRight[j];
                if (secondRectBL[0] >= firstRectTR[0] || secondRectTR[0] <= firstRectBL[0]) continue;
                if (secondRectTR[1] <= firstRectBL[1] || secondRectBL[1] >= firstRectTR[1]) continue;
                int pntAx = Math.max(firstRectBL[0], secondRectBL[0]);
                int pntAy = Math.max(firstRectBL[1], secondRectBL[1]);
                int pntBx = Math.min(firstRectTR[0], secondRectTR[0]);
                int pntBy = Math.min(firstRectTR[1], secondRectTR[1]);
                int sideA = pntBx - pntAx;
                int sideB = pntBy - pntAy;
                ans = Math.max(ans, Math.min(sideA, sideB));
            }
        }
        return (long) ans * ans;
    }
}

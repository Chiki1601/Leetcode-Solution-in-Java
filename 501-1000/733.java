class Solution {
    private static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0 || image[sr][sc] == newColor)
            return image;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int height = image.length, width = image[0].length;
        int original = image[sr][sc];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            image[cur[0]][cur[1]] = newColor;
            int tx = 0, ty = 0;
            for(int i = 0; i < 4; i++){
                tx = cur[0] + dir[i][0];
                ty = cur[1] + dir[i][1];
                if(tx >= 0 && tx < height && ty >= 0 && ty < width && image[tx][ty] == original)
                    q.offer(new int[]{tx, ty});
            }
        }
        return image;
    }
}

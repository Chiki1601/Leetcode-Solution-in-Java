class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int a[][]=new int[grid.length][grid[0].length];
        int b[]=new int[grid.length];
        int c[]=new int[grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            int s=0,p=0;
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                {
                    s++;
                }
                else
                {
                    p++;
                }
            }
            b[i]=p-s;
        }
        for(int i=0;i<grid[0].length;i++)
        {
            int s=0,p=0;
            for(int j=0;j<grid.length;j++)
            {
                if(grid[j][i]==0)
                {
                    s++;
                }
                else
                {
                    p++;
                }
            }
            c[i]=p-s;
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                a[i][j]=b[i]+c[j];
            }
        }
        return a;
    }
}

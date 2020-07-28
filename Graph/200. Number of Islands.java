class Solution {

    int m, n;
    public int numIslands(char[][] grid) {
        if(grid.length==0)return 0;
        this.m=grid.length;
        this.n=grid[0].length;
       
        int noOfIslands=0;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    noOfIslands++;
                    }
            }
        }
        return noOfIslands;
    }
    public void dfs(char[][] g, int i, int j)
    {
        g[i][j]='0';
        int[] x={-1,0,0,1};
        int[] y={0,-1,1,0};
        
        //do dfs for 4 adjacets of curr val
        for(int k=0;k<4;k++)
        {
            int x_i=i+x[k];
            int y_j=j+y[k];
            if(isSafe(x_i, y_j) && g[x_i][y_j]=='1')
                dfs(g, x_i, y_j);
        }
    }
    public boolean isSafe(int i , int j)
    {
        return (i>=0 && i<m && j>=0 && j<n);
    }
}
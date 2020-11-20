class Solution {
    int m;
    int n;
    boolean[][] vis;
    int area=0;    
    public int maxAreaOfIsland(int[][] grid) {
    
        this.m = grid.length;
        this.n=grid[0].length;
         this.vis = new boolean[m][n];
        
        int maxArea= 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !vis[i][j])
                {
                    
                   area= dfs(i,j, grid);
                    maxArea= Math.max(maxArea, area);
                    area=0;
                }
            }
        }
        return maxArea;
    }
    public int dfs(int i, int j, int[][] grid){
        vis[i][j]=true;
         area++; 

        int[] x={-1,1,0,0};
        int[] y={0,0,-1,1};
        
        for(int k=0;k<4;k++){
            int x1  = i+x[k];
            int x2  = j+y[k];
            if(x1>=0 && x1<m && x2>=0 && x2<n && !vis[x1][x2] && grid[x1][x2]==1)
            {       
                       
                dfs(x1,x2,grid);
            }
        }
        return area;
    }
}

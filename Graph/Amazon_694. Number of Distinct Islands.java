class Solution {
    int m;
    int n;
    public int numDistinctIslands(int[][] grid) {
        
        HashSet<String> set=new HashSet<String>();
        if(grid.length==0)return 0;
        this.m=grid.length;
        this.n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                StringBuilder sb=new StringBuilder();
                if(grid[i][j]==1)
                {
                    dfs(i,j,grid,sb,".");
                    set.add(new String(sb));
                }
            }
        }
        return set.size();
    }
    public void dfs(int i, int j, int[][] grid, StringBuilder sb, String toAppend){
        grid[i][j]=0;
        sb.append(toAppend);
        //1,0//-1,0//0,-1//0,1

        //down
        if(i+1>=0 && i+1<m && j>=0 && j<n  &&grid[i+1][j]==1)
            dfs(i+1, j, grid, sb,"D");
        //up
        if(i-1>=0 && i-1<m && j>=0 && j<n  &&grid[i-1][j]==1)
            dfs(i-1, j, grid, sb,"U");
        
        //left
        if(i>=0 && i<m && j-1>=0 && j-1<n  &&grid[i][j-1]==1)
            dfs(i, j-1, grid, sb,"L");
        
        //right
        if(i>=0 && i<m && j+1>=0 && j+1<n  &&grid[i][j+1]==1)
            dfs(i, j+1, grid, sb,"R");
        sb.append("/");
        }
}

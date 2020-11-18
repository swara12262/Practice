class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
         if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        Queue<int[]> q=new LinkedList<int[]>();
        q.add(new int[]{0,0});
        int[] x={-1,1,0,0, -1,-1 ,1,1};
        int[] y= {0,0,-1,1,-1, 1,-1,1};
        int m=grid.length;
        int n = grid[0].length;
        
        while(!q.isEmpty()){
         
            int[] tmp=q.remove();
            int i= tmp[0];
            int j=tmp[1];
            int dist = grid[i][j];
            if(i==m-1 && j==n-1)
                return dist+1;
            for(int k=0;k<8;k++){
                int x_i  = i+x[k];
                int y_j  = j+y[k];
                
                if(x_i>=0 && x_i<m && y_j>=0 && y_j<n && grid[x_i][y_j]==0){
                    grid[x_i][y_j]=dist+1;
                    q.add(new int[]{x_i, y_j});
                }
            }
            
        }
        return -1;
    }
}

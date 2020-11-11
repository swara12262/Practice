class Solution {

    public int orangesRotting(int[][] grid) {
        int ans=-1;
        int m=grid.length;
        int n=grid[0].length;    

        int[] x={1,-1,0,0};
        int[] y={0,0,1,-1};
        
        Queue<int[]> q=new LinkedList<int[]>();
        int  i=0,j=0;
        
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i, j});
                }
            }
        }
        q.add(null);
        while(!q.isEmpty()){
                
            int[] tmp=q.poll();
            if(tmp==null){
                ans++;
                if(!q.isEmpty())
                    q.add(null);
            }else{
                
                for(int k=0;k<4;k++){
                    int x_i = tmp[0]+x[k];
                    int y_j = tmp[1]+y[k];

                    if(x_i>=0 & x_i<m && y_j>=0 && y_j<n && grid[x_i][y_j]==1)
                    {
                        grid[x_i][y_j]=2;
                        q.add(new int[]{x_i, y_j});
                    }
                }
            }
            
        }
        for(i=0;i<m;i++){
            for( j=0;j<n;j++){
                if(grid[i][j]==1)return -1;
            }
        }
        
        return ans;
    }
}

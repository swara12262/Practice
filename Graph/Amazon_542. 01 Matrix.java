class Solution {
    public int[][] updateMatrix(int[][] m) {
        Queue<int[]> q=new LinkedList<int[]>();
        int m1 = m.length;
        int n1 = m[0].length;
        int[][] dist=new int[m1][n1];
        
        for(int i=0;i<m1;i++){
            for(int j=0;j<n1;j++){
                if(m[i][j]==0)
                {
                    q.add(new int[]{i,j});
                    dist[i][j]=0;
                }else
                {
                dist[i][j]=Integer.MAX_VALUE;
            }
                
            }
        }
        int[] x={1,-1,0,0};
        int[] y={0,0,1,-1};
        
        while(!q.isEmpty()){
            int[] tmp=q.remove();
            int i=tmp[0];
            int j=tmp[1];
            for(int k=0;k<4;k++){
                int x_i = i+x[k];
                int y_j = j+y[k];
                if(x_i>=0 && x_i<m1 && y_j>=0&& y_j<n1 && 
                   dist[x_i][y_j] > dist[i][j]+1  )
                {
                    dist[x_i][y_j] = dist[i][j]+1;
                    q.add(new int[]{x_i,y_j});
                }
            }    
        }
    return dist;
        
    }
}

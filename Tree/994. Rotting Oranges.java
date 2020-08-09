class Pair{
    int i; int j;
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    boolean[][] vis;
    int res;
    int max_res;
    Queue<Pair> que;
    int m;
    int n;
    public int orangesRotting(int[][] grid) {
        
        que=new LinkedList();
        m=grid.length;
        n=grid[0].length;
        
        vis=new boolean[m][n];
        int i=0, j=0;
        for( i=0;i<m;i++){
            for( j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==2)
                {
                    que.add(new Pair(i, j));
                }
            }
        }
        bfs(grid);
        for(i=0;i<m;i++){
            for( j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return res;
        
    }
    public void bfs(int[][] grid){
        
        int x[]={1, -1, 0,  0};
        int y[]={0,  0, 1, -1};
        que.add(null);
        while(!que.isEmpty()){
            
            if(que.peek()==null)
            {
                res++;
                que.poll();
                if(que.peek()!=null)
                    que.add(null);
                else
                    res--;
            }
            else
            {
                Pair tmp=que.poll();
                vis[tmp.i][tmp.j]=true;
                for(int k=0;k<4;k++){
                    int x_i = tmp.i+x[k];
                    int y_j = tmp.j+y[k];
                    if(isSafe(x_i, y_j) && grid[x_i][y_j]==1){
                        grid[x_i][y_j]=2;
                        que.add(new Pair(x_i, y_j));
                    }
                }  
            }
        }
    }
    public boolean isSafe(int i, int j){
        return (i>=0 && j>=0 && i<m && j<n && !vis[i][j]);
    }
}

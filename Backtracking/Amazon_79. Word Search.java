class Solution {
    int m, n;
    boolean[][] vis;
    public boolean exist(char[][] board, String word) {
     
        if(word.length()==0)
            return true;
        
        char ch = word.charAt(0);
        int index =1;
        this.m=board.length;
        this.n= board[0].length;
        vis=new boolean[m][n];
        
        for(int i=0;i<m ;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==ch && !vis[i][j]){
                    vis[i][j]=true;
                    if(dfs(board, word, i, j, index))
                        return true;
                    vis=new boolean[m][n];
                    }
                    
                }
            }
        return false;
        }
        boolean dfs(char[][]  board, String word, int i, int j, int index)
        {
           // System.out.println(index+"**");
            if(index==word.length())
                return true;
            int x[]= {-1, 1,0, 0};
            int y[] = {0, 0, -1, 1};
            boolean res=false;
                for(int k=0;k<4;k++){
                    int x_i = i + x[k];
                    int y_j = j + y[k];
                    
                    if(x_i<m && x_i>=0 &&y_j<n && y_j>=0 &&
                       board[x_i][y_j]==word.charAt(index) && !vis[x_i][y_j])
                    {
                        vis[x_i][y_j]=true;
                        if(dfs(board, word, x_i, y_j, index+1))
                            return true;
                                
                    }
                    }
            vis[i][j]=false;

            return false;
        }
}

class Solution {
    boolean[][] vis;
    int m, n;
    public List<String> findWords(char[][] board, String[] words) {
       
        this.m=board.length;
        this.n=board[0].length;
        vis=new boolean[m][n];
        boolean found=false;
        List<String> res=new ArrayList<String>();
        for(int k=0;k<words.length;k++){
            found=false;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(words[k].charAt(0)==board[i][j]){
                    if(dfs(board, i, j,words[k], 1))
                    {
                        found=true;
                    }      
                    }
                }
                if(found){
                        res.add(words[k]);
                        vis=new boolean[m][n];
                        break;
                }
            }
        }
        return res;
    }
    public boolean dfs(char[][] b, int i, int j, String word, int pos){
        vis[i][j]=true;
        
        int[] x={0,0,-1,1};
        int[] y={-1,1,0,0};
        if(pos==word.length())
            return true;
        
        for(int k=0;k<4;k++){
            int x_i=i+x[k];
            int y_j=j+y[k];
            if(x_i>=0 && x_i<m && y_j>=0 && y_j<n && vis[x_i][y_j]==false 
              && b[x_i][y_j]==word.charAt(pos)){
               
                if(dfs(b, x_i, y_j,word, pos+1))
                    return true;
            }
        }
        vis[i][j]=false;
        return false;
    }
}

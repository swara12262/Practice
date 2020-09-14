class TicTacToe {

    int[] r, c;
    int d1, d2, s;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        s=n;
        r=new int[n];
        c=new int[n];
        d1=0;d2=0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int p) {
        if(p==1){
           r[row]++;
            c[col]++;
            if(row==col)d1++;
            if(row+col==s-1)d2++;
            if(d1==s || d2==s || r[row]==s || c[col]==s)
                return 1;
            else
                return 0;
        }
        else
        {
            r[row]--;
            c[col]--;
            if(row==col)d1--;
            if(row+col==s-1)d2--;
            if(d1==-s || d2==-s || r[row]==-s || c[col]==-s)
                return 2;
            else
                return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

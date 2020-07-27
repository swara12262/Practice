class Pair{
    int i; int j;
    Pair(int i, int j)
    {
        this.i=i;
        this.j=j;
    }
        
}
class Solution {
    
    public void wallsAndGates(int[][] rooms) {
        
        Queue<Pair> que=new LinkedList<Pair>();
        for(int i=0;i<rooms.length;i++)
        {
            for(int j=0;j<rooms[i].length;j++)
            {
                if(rooms[i][j]==0)
                    que.add(new Pair(i, j));
            }
        }
        while(!que.isEmpty())
        {
            Pair tmp=que.remove();
            int[] x={-1,0,0,1};
            int[] y={0,-1,1,0};
            
            for(int k=0;k<4;k++)
            {
                int tmp_i = tmp.i+x[k];
                int tmp_j = tmp.j+y[k];
                if(isSafe(tmp_i, tmp_j, rooms) && rooms[tmp_i][tmp_j]!=-1
                   && rooms[tmp_i][tmp_j]>rooms[tmp.i][tmp.j]+1)
                {
                    rooms[tmp_i][tmp_j]=rooms[tmp.i][tmp.j]+1;
                    que.add(new Pair(tmp_i,tmp_j));
                }
            }
        }
    }
    public boolean isSafe( int i, int j, int[][] rooms)
    {
        return (  i>=0 && i<rooms.length && j>=0 && j<rooms[i].length);
    }
}

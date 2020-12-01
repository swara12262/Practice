class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        Queue<int[]> q=new LinkedList<int[]>();
        int m=maze.length;
        int n=maze[0].length;
        
        int[][] dist=new int[m][n];
        for(int[] row: dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        q.add(start);
        dist[start[0]][start[1]]=0;
        while(!q.isEmpty()){
            int[] tmp=q.remove();
            int[] i ={1,-1,0,0};
            int[] j ={0,0,1,-1};
            for(int k=0;k<4;k++){
                int x= i[k]+ tmp[0]; 
                int y= j[k]+ tmp[1];
                int cnt=0;
                while(x>=0 && x<m && y>=0 && y<n && maze[x][y]==0){
                    cnt++;
                    x+=i[k];
                    y+=j[k];
                }
                if(dist[x-i[k]][y-j[k]] > dist[tmp[0]][tmp[1]]+cnt){
                    dist[x-i[k]][y-j[k]] = dist[tmp[0]][tmp[1]]+cnt;
                    q.add(new int[]{x-i[k], y-j[k]});
                }
            }
        }
         return dist[dest[0]][dest[1]]==Integer.MAX_VALUE?-1:  dist[dest[0]][dest[1]]; 
    }
}

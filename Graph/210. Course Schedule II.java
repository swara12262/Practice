class Solution {
    ArrayList<Integer> adj[];
    boolean[] vis;
    int[] indegree;
    int[] res;
    public int[] findOrder(int n, int[][] pre) {
       
        adj=new ArrayList[n];
        vis=new boolean[n];
        res=new int[n];
        indegree=new int[n];
        
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<Integer>();
        
        for(int i=0;i<pre.length;i++){
            adj[pre[i][1]].add(pre[i][0]);
            indegree[pre[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            int v= q.poll();
            res[cnt] =v;
            cnt++;
            for(int u: adj[v])
            {
                indegree[u]--;
                if(indegree[u]==0)
                    q.add(u);
            }
        }
        if(cnt==n)
            return res;
        return new int[]{};
        
    }
}

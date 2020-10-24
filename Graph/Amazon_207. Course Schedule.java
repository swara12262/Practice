class Solution {
    ArrayList<Integer> adj[];
    boolean vis[];
    boolean recstk[];
    public boolean canFinish(int n, int[][] pq) {
        
        adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList();
        }
        for(int i=0;i<pq.length;i++){
            adj[pq[i][0]].add(pq[i][1]);
        }
        vis=new boolean[n];
        recstk=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i])
                if(dfs(i))
                    return false;
                
        }
        return true;
    }
    public boolean dfs(int v){
        vis[v]=true;
        recstk[v]=true;
        
        for(int u: adj[v]){
            if(!vis[u] && dfs(u))
                return true;
            if(recstk[u])
                return true;
        }
        recstk[v]=false;
        return false;
        
    }
}

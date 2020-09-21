class Solution {
    LinkedList<Integer> adj[];
    public int countComponents(int n, int[][] edges) {
        adj=new LinkedList[n];
        for(int i=0;i<n;i++)
            adj[i]=new LinkedList();
        
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]); 
            adj[edges[i][1]].add(edges[i][0]); 
        }
        
        boolean[] vis=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false)
            {
                dfs(i, vis);
                ans++;
            }
        }
        return ans;
        
    }
    void dfs(int u, boolean[] vis){
        vis[u]=true;
        for(int v: adj[u]){
            if(!vis[v])
                dfs(v, vis);
        }
    }
    
}

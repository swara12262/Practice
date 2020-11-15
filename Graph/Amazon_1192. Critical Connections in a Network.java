class Solution {
    //to build adjancey list
    ArrayList<Integer>[] graph;
    //to keep track of lowest reachable nodes
    int[] lowTimes;
    //to keep track of dicovery times of nodes
    int[] discoveryTimes;
    List<List<Integer>> res;    
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    
        graph=new ArrayList[n];
        lowTimes=new  int[n];
        discoveryTimes=new  int[n];
        time =0;
        buildGraph(connections);
        
        res=new ArrayList();
        boolean[] vis=new boolean[n];
        //dfs for tarzens algorithm to calculate  critical connections
        dfs(vis, 0, -1);
        return res;
    }
    public void dfs(boolean[] vis, int cur, int parent){
        vis[cur]=true;
        lowTimes[cur]= discoveryTimes[cur]=time++;
        
        for(int v: graph[cur]){
            //if it is a parent node then do nothing
            if(v==parent)continue;
            if(!vis[v])
            {
                dfs(vis, v, cur);
                //propogate updated low tumes to parents in dfs hirarachy
                lowTimes[cur]= Math.min(lowTimes[v], lowTimes[cur]);
                
                //condition for articulation point then cur node is articulation point
                if(lowTimes[v]>discoveryTimes[cur])
                    res.add(Arrays.asList(cur, v));
                
            }else{
                //if node is already visted and not a parent node that means this is a back ege hence update the lowtime of this var 
                lowTimes[cur] =Math.min(lowTimes[cur], discoveryTimes[v]); 
            }
        }
            
    }
    public void buildGraph(List<List<Integer>> connections){
        for(int i=0;i<graph.length;i++)
            graph[i]=new ArrayList<Integer>();
        
        for(List<Integer> con : connections){
            int i= con.get(0);
            int j= con.get(1);
            graph[i].add(j);
            graph[j].add(i);
        }
    }
}

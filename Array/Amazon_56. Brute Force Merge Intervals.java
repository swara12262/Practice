class Solution {
    Map<int[], List<int[]>> graph;
    Map<Integer, List<int[]>> connComp;
    Set<int[]> vis;
    public boolean overalap(int[] i1, int[] i2){
        return i2[0]<=i1[1] && i2[1]>=i1[0] ;
    }
    public void buildGraph(int[][] in){
        graph=new HashMap<int[], List<int[]>>();
        for(int[] i: in){
            graph.put(i, new LinkedList<int[]>());
        }
        
        for(int[] i1:in){
            for(int[] i2: in){
                if(overalap(i1,i2)){
                    graph.get(i1).add(i2);
                    graph.get(i2).add(i1);
                }
            }
        }
    }
    public void dfs(int[] i, int compNo){
        Stack<int[]> stk=new Stack<int[]>();
        stk.add(i);
        while(!stk.isEmpty())
        {
            int[] cur=stk.pop();
            if(!vis.contains(cur))
                vis.add(cur);
            List<int[]> lst=connComp.getOrDefault(compNo, new LinkedList<int[]>());
            lst.add(cur);
            connComp.put(compNo, lst);
            
            for(int [] child: graph.get(cur)){
                if(!vis.contains(child))
                {
                    stk.add(child);
                    
                }
            } 
        }
    }
    public int connectedCom(int[][] in){
        int compNo=0;
        vis=new HashSet<int[]>();
        connComp=new HashMap<Integer, List<int[]>>();
        
        for(int[] i:in){
            if(!vis.contains(i))
            {
                dfs(i, compNo);
                compNo++;
            }
        }
        return compNo;
    }
    public int[] mergeNodes(List<int[]> nodes){
        int minStart=nodes.get(0)[0];
        for(int[] n: nodes){
            minStart=Math.min(minStart, n[0]);
            
        }
        int maxEnd=nodes.get(0)[1];
        for(int[] n: nodes){
            maxEnd=Math.max(maxEnd, n[1]);
        }
         return new int[]{minStart, maxEnd};
    }
    public int[][] merge(int[][] intervals) {
        buildGraph(intervals);
        int noOfConCom=connectedCom(intervals);
        List<int[]> mergedList=new ArrayList<int[]>();
        
        for (int comp = 0; comp < connComp.size(); comp++) {
            mergedList.add(mergeNodes(connComp.get(comp)));
            
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}


class Solution {
    
    
    public int minCost(int[][] costs) {
        
        int n=costs.length;
        if(n==0)return 0;
        int[] prev=costs[n-1];
        
        for(int i=n-2;i>=0;i--)
        {
            int[] cur=costs[i];
            cur[0]+= Math.min(prev[1],prev[2]);
            cur[1]+= Math.min(prev[0],prev[2]);
            cur[2]+= Math.min(prev[0],prev[1]);
            prev=cur;
        }
        return Math.min(prev[0], Math.min(prev[1], prev[2]));
    }
      
}

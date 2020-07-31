
class Solution {
    
    int[][] a;
    private Map<String, Integer> map;
    
    public int minCost(int[][] costs) {
        if(costs.length==0)return 0;
        a= costs;
        map=new HashMap();
        
        return Math.min(paint(0, 0), Math.min(paint(0, 1), paint(0,2)));
    }
    public int paint(int n, int c)
    {
        int total_cost=a[n][c];
        if(map.containsKey(getKey(n, c)))
            return map.get(getKey(n,c));
        if(n==a.length-1)return total_cost;
        if(c==0)
            total_cost+=Math.min(paint(n+1, 1), paint(n+1, 2));
        else if( c==1)
            total_cost+=Math.min(paint(n+1, 0), paint(n+1, 2));
        else
            total_cost+=Math.min(paint(n+1, 0), paint(n+1, 1));
        map.put(getKey(n,c), total_cost);
        return total_cost;
    }
    public String getKey(int n, int c)
    {
        return n+" "+c;
    }
}

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
    
        int[][] g=new int[n][n];
        TreeMap<Integer, Integer> in=new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> out=new TreeMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            in.put(i, 0);
            out.put(i,0);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(knows(i,j))
                {
                    g[i][j]=1;
                    
                    if(i!=j){
                        
                        in.put(j, in.get(j)+1);
                        out.put(i, out.get(i)+1);
                    }                    
                }
                else
                {
                    g[i][j]=0;
                }
            }
        }
        int cel=-1;
        for(Map.Entry en: in.entrySet()){
            
            if((int)en.getValue()==n-1)
            {
                cel=(int)en.getKey();
                if((int)out.get(cel)==0)
                    return cel;
            }
        }
        
        return -1;
        
    }
}

class Solution {
    public int trap(int[] ht) {
        int ans=0;
        int lt_max=0, rt_max=0;
        
        for(int i=1;i<ht.length-1;i++){
            
            lt_max=ht[i]; rt_max=ht[i];
            for(int j=0;j<i;j++)
                lt_max = (Math.max(lt_max , ht[j]));
                
            for(int j=i+1;j<ht.length;j++)
                rt_max = (Math.max(rt_max , ht[j]));
            
            ans=ans+(Math.min(lt_max, rt_max)-ht[i]);
        }
        return ans;
        
    }
}

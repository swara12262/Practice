class Solution {
    public int lastStoneWeight(int[] stones) {
        
        ArrayList<Integer> list=new ArrayList();
        for(int i=0;i<stones.length;i++)
            list.add(stones[i]);
    
        while(list.size()>1)
        {
            int x=Collections.max(list);
            list.remove(new Integer(x));
            int y=Collections.max(list);
            list.remove(new Integer(y));
            if(x!=y)
                list.add(Math.abs(y-x));
            
        }
        if(list.size()==1)
            return list.get(0);
        return 0;
        
    }
}

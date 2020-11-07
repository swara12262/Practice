class Solution {
    public int calPoints(String[] ops) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C"))
                list.remove(list.size()-1);
            
            else if(ops[i].equals("D")){
                int n = list.get(list.size()-1);
                list.add(n*2);
            }
            else if(ops[i].equals("+"))
            {
                int n  =list.size();
                list.add(list.get(n-1) + list.get(n-2));  
            }
            else
                list.add(Integer.parseInt(ops[i]));
          //  System.out.println(list);
        }
        int ans=0;
        for(int i:list)
            ans+=i;
        
        return ans;
        
    }
}

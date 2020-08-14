class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        this.res=new ArrayList();
        List<Integer> cur=new ArrayList();
        helper(n, k, cur, 1);
        return res;
        
    }
    void helper(int n , int k, List<Integer> cur, int i){
        if(cur.size()==k)
        {
           // System.out.println(cur);
            res.add(new ArrayList(cur));
           // System.out.println(res);
            cur=new ArrayList();
            return;
        }
        for( ;i<=n;i++){
            cur.add(i);
            helper(n, k, cur, i+1);
            cur.remove(new Integer(i));   
            
        }
    }
}

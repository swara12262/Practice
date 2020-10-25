class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res=new ArrayList<String>();
        backtrack(res,"" ,0,0,n);
        return res;
    }
    void backtrack(ArrayList<String> res,String cur, int open, int close, int max){
        if(cur.length()==max*2){
            res.add(cur);
            return;
        }
        if(open<max)
            backtrack(res, cur+"(", open+1, close, max);
        if(close<open)
            backtrack(res, cur+")", open, close+1, max);
       
    }
}

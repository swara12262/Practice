class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res=new ArrayList<String>();
        char[] ch=new char[2*n];
        generate(ch, 0, res);
        return res;
    }
    void generate(char[] cur, int pos, ArrayList<String> res){
        if(cur.length==pos)
        {
            if(isValid(cur))
                res.add(new String(cur));
        }else{
            cur[pos]= '(';
            generate(cur, pos+1, res);
            cur[pos]= ')';
            generate(cur, pos+1, res);
        }
    }
    public boolean isValid(char[] ch){
        int balance=0;
        for(char c: ch){
            if(c=='(')balance++;
            else balance--;
            if(balance<0)return false;
        }
        return balance==0;
    }
}

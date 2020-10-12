class Solution {
    public int maxDepth(String s) {
        int res=0;
        if(s.length()==0 || s.equals(" "))
            return res;
        
        int bl=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')bl++;
            else if(s.charAt(i)==')')bl--;
            res=Math.max(res, bl);
        }
        return res;
    }
}

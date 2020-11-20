class Solution {
    public String convert(String s, int numRows) {
     
        if(numRows==1)return s;
        List<StringBuilder> sblist=new ArrayList<StringBuilder>();
        
        int curRow=0;
        boolean dir=false;
        for(int i=0;i<Math.min(numRows, s.length());i++){
            sblist.add(new StringBuilder());
        }
        
        for(char ch: s.toCharArray()){
            sblist.get(curRow).append(ch);
            //decide weather to go down or up
            if(curRow==0 || curRow==numRows-1)dir = !dir;
            curRow += dir?1:-1;
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder sb: sblist)
            res.append(sb);
        
        return new String(res);
        
    }
}

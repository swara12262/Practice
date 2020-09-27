class Solution {
    public String reverseWords(String s) {
        int l=0, r=s.length()-1;

        //remove leading and trailing spaces
        while(l<=r && s.charAt(l)==' ')l++;
        while(l<=r && s.charAt(r)==' ')r--;
        
        
        LinkedList<String> lst=new LinkedList<String>();
        StringBuilder sb=new StringBuilder();
        
        while(l<=r){
            
            char c=s.charAt(l);
           // System.out.println(c+"");
            if(sb.length()!=0 && c==' ')
            {
                
                lst.addFirst(sb.toString());
                sb.setLength(0);
            }
            else if(c!=' ')sb.append(c);
            l++;
        }
        lst.addFirst(sb.toString());
        return String.join(" ", lst);
        
    }
}

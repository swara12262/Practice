class Solution {
    public String minWindow(String s, String t) {
     
        int l=0,r=0;
        int min=Integer.MAX_VALUE;
        String ans="";
        
        HashMap<Character, Integer> tmap=new HashMap();
        for(int i=0;i<t.length();i++){
             tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0)+1);   
            }
        
        while(l<=r && l< s.length() && r<s.length()){
        
            HashMap<Character, Integer> curmap=new HashMap();
            boolean flg=true;
            String tmp=s.substring(l, r+1);
            
            for(int i=0;i<tmp.length();i++){
             curmap.put(tmp.charAt(i), curmap.getOrDefault(tmp.charAt(i), 0)+1);   
            
            }
            for(Map.Entry en: tmap.entrySet()){
                if(!curmap.containsKey(en.getKey()))
                {
                    flg=false;
                    break;
                }
                if( (int)en.getValue() > (int) curmap.get(en.getKey()))
                {
                    flg=false;
                    break;
                }
            }
            
            if(!flg)
                r++;
            else
            {
                if(min>r-l+1){
                    min =   r-l+1;
                    ans=s.substring(l,r+1);
                }
                
                l++;
            }
        }
        return ans;
        
        
    }
}

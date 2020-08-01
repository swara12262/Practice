class Solution {
    public String sortString(String s) {
        char[] chr=new char[26];
        
        for(int i=0;i<s.length();i++)
            chr[s.charAt(i)-'a']++;
        
        String res="";
        while(true){
            
            boolean resUpdated=false;
            for(int i=0;i<26;i++)
            {
                if(chr[i]>0){
                    res+=(char)(i+'a');
                    resUpdated=true;
                    chr[i]--;
                }
            }
            resUpdated=false;
            for(int i=25;i>=0;i--)
            {
                if(chr[i]>0){
                    res+=(char)(i+'a');
                    resUpdated=true;
                    chr[i]--;
                }
            }
            if(!resUpdated)
                break;
        }
        return res;
    }
    
}

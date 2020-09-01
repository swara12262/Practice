class Solution {
    public int compress(char[] chars) {
        int i=0, len=0,cnt=0;
        if(chars.length==1)
            return 1;
        for(i=0;i<chars.length;i++)
        {
           if(i+1== chars.length || chars[i+1]!=chars[i]){
               chars[len++]=chars[cnt];
               if(i>cnt){
                    char[] ch=(""+(i-cnt+1)).toCharArray();
                    for(char c: ch)
                       chars[len++]=c;
               }
               cnt=i+1;
           }
            
            
        }
        return len;
    }
}

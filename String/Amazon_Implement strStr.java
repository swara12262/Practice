class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())return 0;
        if(haystack.length()==needle.length())
             return haystack.equals(needle)?0:-1;
        int j=0;
        int index=0;
        int i=0;
            char ch=needle.charAt(i);
            while(j<haystack.length()){
                i=0;
                if(haystack.charAt(j)==ch)
                {
                    index=j;
                    int k=j+1;i++;
                    while(i<needle.length() && k<haystack.length()){
                        if(haystack.charAt(k)!=needle.charAt(i))
                            break;
                        i++;k++;
                    }
                    if(i==needle.length())
                        return index;
                }
                j++;
            }
            
        return -1 ;
        }
        
    }

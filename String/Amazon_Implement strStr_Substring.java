class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())return 0;
        int l=needle.length();
        for(int i=0;i<haystack.length()-l+1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(haystack.substring(i, i+l).equals(needle))
                    return  i;
            }            
        }
        return -1;
               
    }
}

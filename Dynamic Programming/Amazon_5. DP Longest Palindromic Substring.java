class Solution {
    public String longestPalindrome(String s) {
        int l=s.length();
        int[][] dp=new int[l][l];
        int start=0;
        int longestLen=1;
        
        for(int i=0;i<l;i++)
            dp[i][i]=1;
        
        for(int i=0;i<l-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=1;
                longestLen=2;
                start=i;
            }   
        }
       
        for(int len=3;len<=l;len++){
            for(int i=0;i<l-len+1;i++){
                int j=len+i-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1)
                {
                    dp[i][j]=1;
                    if(len> longestLen){
                        start=i;
                        longestLen=len;
                    }
                }
            }
        }
                

        return s.substring(start, start+longestLen);
        
    }
}

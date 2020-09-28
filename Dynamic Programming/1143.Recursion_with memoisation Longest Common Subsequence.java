class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++)
                dp[i][j]=-1;
        }
        return lcs(text1.toCharArray(), text2.toCharArray(), m,n );
    }
    public int lcs(char[] s1, char[] s2, int m, int n){
        if(dp[m][n]!=-1)return dp[m][n];
        
        if(m==0 || n==0)dp[m][n] =0;
        else{
            
            if(s1[m-1]==s2[n-1])
            {
               dp[m][n]= 1+lcs(s1, s2, m-1, n-1);
            }
            else
                dp[m][n]= Math.max(lcs(s1, s2, m-1, n),
                        lcs(s1, s2, m, n-1));
        }
        
        return dp[m][n];
    }
    
}

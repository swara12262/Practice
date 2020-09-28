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
        for(int i=0;i<=m;i++)
                dp[i][0]=0;
        for(int i=0;i<=n;i++)
                dp[0][i]=0;
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
    
}

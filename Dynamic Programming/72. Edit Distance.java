class Solution {
    public int minDistance(String word1, String word2) {
     
        //to solve it in bottom up manner 
        //create a table to store subproblems to utilise it again
        int m=word1.length();
        int n=word2.length();
        
        int  dp[][]=new int[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                //if first string is empty then only option is add all chars from second
                if(i==0)
                    dp[i][j]=j;
                
                //if second string is empty then only option is remove all chars from 1st
                else if(j==0)
                    dp[i][j]=i;
                //do nothing and copy from diagonal ie. ignore 
                else if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                    else
                    {
                        //insert , //remove // replace
                        dp[i][j]=1+Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                    }
            }
        }
        return dp[m][n];
    }
}

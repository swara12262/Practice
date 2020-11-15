class Solution {
    public int maximalSquare(char[][] matrix) {
     
        int m=matrix.length;
        if(m==0 )return 0;
        int n=matrix[0].length;
        
        
        //store the max size of sqare at dp[i][j]
        int[][] a=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1')
                    a[i][j]=1;
                else
                    a[i][j]=0;
            }
        }
        
        int dp[][]=new int[m][n];
        int max=0;
        //base condition
        for(int i=0;i<m;i++){
            dp[i][0]=a[i][0];
            max=Math.max(max, dp[i][0]);                
        }
        for(int i=0;i<n;i++){
            dp[0][i]=a[0][i];
            max=Math.max(max, dp[0][i]);                
        }
        
        //for remaining elements from dp array
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a[i][j]==1)
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                max=Math.max(dp[i][j], max);
            }
        }
        return max*max;
    }
}

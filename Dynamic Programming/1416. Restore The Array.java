class Solution {
    int dp[];
    static final int mod =1000000007;
    public int numberOfArrays(String s, int k) {
        dp=new int[100001];
        for(int i=0;i<dp.length; i++)
            dp[i]=-1;
        
       return  helper(s, 0, k);
    }
    public int helper(String s, int i, int k){
    if(i==s.length())return 1;
    if(dp[i]!=-1)return dp[i];
    else
    {
        if(s.charAt(i)=='0')return 0;
        long num=0;
        int ans=0;
        
        for(int j=i;j<s.length();j++)
        {
            num=num*10+s.charAt(j)-'0';
            if(num>k)break;
            ans+=helper(s, j+1, k);
            ans%=mod;
        }
        return dp[i]=ans;
    }
        
    }
}

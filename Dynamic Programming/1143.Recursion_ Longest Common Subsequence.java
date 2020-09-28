class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
    }
    public int lcs(char[] s1, char[] s2, int m, int n){
        if(m==0 || n==0)return 0;
        if(s1[m-1]==s2[n-1])
        {
           return 1+lcs(s1, s2, m-1, n-1);
        }
        else
            return Math.max(lcs(s1, s2, m-1, n),
                    lcs(s1, s2, m, n-1));
    }
    
}

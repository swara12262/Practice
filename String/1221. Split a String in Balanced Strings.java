class Solution {
    public int balancedStringSplit(String s) {
        int ans=0;
        int bl=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='R')
                bl--;
            else if(s.charAt(i)=='L')
                bl++;
            
            if(bl==0)
                ans++;
        }
        return ans;
    }
}

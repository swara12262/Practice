class Solution {
    public int lengthOfLongestSubstring(String s) {
     HashSet<Character> set=new HashSet();
        int res=0;
        if(s.length()==1)return 1;
        for(int i=0;i<s.length();i++){
            set.clear();
            for(int j=i;j<s.length();j++){
        
                if(!set.add(s.charAt(j)))
                {
                    //System.out.println(set.toString());
                    res=Math.max(res,  set.size());
                    break;
                }
                else
                {
                    
                    res=Math.max(res,  set.size());
                }
            }
        }
        return res;
    }
}

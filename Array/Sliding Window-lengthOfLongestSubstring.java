class Solution {
    public int lengthOfLongestSubstring(String s) {
     HashSet<Character> set=new HashSet();
        int res=0, i=0, j=0;
        
        while(i<s.length() && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res=Math.max(res, j-i);
            }
            else
                set.remove(s.charAt(i++));
                
        }
        return res;
    }
}

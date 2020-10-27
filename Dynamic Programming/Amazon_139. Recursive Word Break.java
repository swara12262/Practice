class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<String>(wordDict), 0);
    }
    public boolean wordBreak(String s, HashSet<String> wordDict , int start){
        if(s.length()==start)
            return true;
        for(int end=start+1; end<=s.length();end++){
            if(wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end))
                return true;
        }
        return false;
    }
}

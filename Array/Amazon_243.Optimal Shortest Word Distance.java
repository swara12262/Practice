class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ans=words.length;
        int flg1=-1,flg2=-1;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1))
                flg1=i;
            
            if(words[i].equals(word2))
                flg2=i;
            
            if(flg1!=-1 && flg2!=-1){
                ans=Math.min(ans, Math.abs(flg2-flg1));
            }
        }
        return ans;
    }
}

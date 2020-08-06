class TrieNode{
    TrieNode[] child=new TrieNode[26];
    boolean isEnd;
}
class WordDictionary {

    private static TrieNode root;

    public WordDictionary() {    
         root=new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            int index=word.charAt(i)-'a';
            if(cur.child[index]==null)
                cur.child[index]=new TrieNode();
            cur=cur.child[index];
        }
        cur.isEnd=true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchRemainingStr(word, root, 0);
    }
    public boolean searchRemainingStr(String s, TrieNode cur, int i){
  
        if(i<s.length()){            
                char ch=s.charAt(i);
                if(ch>='a' && ch<='z')
                {
                        if(cur.child[ch-'a']!=null && searchRemainingStr(s, cur.child[ch-'a'],i+1 ))
                            return true;
                        return false;
                }
             else
             {
                 for(int index=0;index<26;index++){
                     if(cur.child[index]!=null && searchRemainingStr(s, cur.child[index], i+1))
                            return true;
                 }
                 return false;
             }
            }
            return cur.isEnd;
            
    }
 
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

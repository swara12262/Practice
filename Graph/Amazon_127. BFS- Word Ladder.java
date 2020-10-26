class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l=beginWord.length();
        
        //create a map to store key as generic word and value as list of words which maps to this generic word/
        
        Map<String, List<String>> map=new HashMap<String, List<String>>();
        for(String word: wordList){
            
            for(int i=0;i<l;i++){
                String genWord = word.substring(0,i)+'*'+word.substring(i+1,l);
                
                List<String> lst= map.getOrDefault(genWord, new ArrayList<String>());
                lst.add(word);
                map.put(genWord, lst);
            }
        }
        //pair to store word and its level
        Queue<Pair<String, Integer>> q=new LinkedList<Pair<String, Integer>>();
        q.add(new Pair(beginWord, 1));
        
        //visited map to check if given word is already processed or not
        Map<String, Boolean> vis=new HashMap<String, Boolean>();
        vis.put(beginWord, true);
        
        while(!q.isEmpty()){
            Pair<String, Integer> p=q.remove();
            String s=p.getKey();
            int level=p.getValue();
            for(int i=0;i<l;i++){
                
                String genWord = s.substring(0,i)+'*'+s.substring(i+1,l);
                
                for(String tmpstr : map.getOrDefault(genWord, new ArrayList<String>())){
                    
                    if(tmpstr.equals(endWord))
                        return level+1;
                    
                    if(!vis.containsKey(tmpstr)){
                        vis.put(tmpstr, true);
                        q.add(new Pair(tmpstr, level+1));
                    }
                }        
            }
            
        }
        return 0;
    }
}

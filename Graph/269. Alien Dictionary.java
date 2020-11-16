class Solution {
    public String alienOrder(String[] words) {
        //map to store indegree of node
        Map<Character, Integer> indegree=new HashMap<Character, Integer>();
        Map<Character, List<Character>> adjlist=new HashMap<Character, List<Character>>();
        
        for(String word: words){
            for(int i=0;i< word.length();i++){
                char ch=word.charAt(i);
                indegree.put(ch,0);
                adjlist.put(ch,new ArrayList<Character>());
            }
        }
        
        //build relations and updated maps
        for(int i=0;i<words.length-1;i++){
            String word1= words[i];
            String word2= words[i+1];
            //check if word2 is not a prefix of word1
            if(word1.length()>word2.length() && word1.startsWith(word2))
                return "";
            
            //find first non mateched char and add corresponding relation
            for(int j=0;j<Math.min(word1.length(), word2.length());j++){
                
                if(word1.charAt(j)!=word2.charAt(j)){
                      adjlist.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j))+1);
                    break;
                }
            }
        }
        
        //Build output
        StringBuilder sb=new StringBuilder();
        Queue<Character> q=new LinkedList<Character>();
        
        //add all indegree 0 chars in queue
        for(Character ch: indegree.keySet()){
            if(indegree.get(ch).equals(0))
                q.add(ch);
        }
        
        while(!q.isEmpty()){
            Character ch = q.remove();
            sb.append(ch);
            for(Character adj: adjlist.get(ch)){
                indegree.put(adj, indegree.get(adj)-1);
                if(indegree.get(adj).equals(0))
                    q.add(adj);
            }
        }
        //if cycle
        if(sb.length()< indegree.size())return "";
        return new String(sb);
    }
}

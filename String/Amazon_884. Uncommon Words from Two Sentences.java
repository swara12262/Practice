class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        ArrayList<String> res=new ArrayList<String>();
            TreeMap<String, Integer> count=new TreeMap<String, Integer>();
            
            for(String s: A.split(" "))
                count.put(s, count.getOrDefault(s, 0)+1);
            for(String s: B.split(" "))
                count.put(s, count.getOrDefault(s, 0)+1);    
            
            for(Map.Entry<String, Integer>  en: count.entrySet()){
                if(en.getValue()==1)
                    res.add(en.getKey());
            }    
            return res.toArray(new String[res.size()]);   
    }
}

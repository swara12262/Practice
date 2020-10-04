class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map=new HashMap();
        List<List<String>> ans=new ArrayList();
        
        for(String s: strs){
            char[] tmp=s.toCharArray();
            Arrays.sort(tmp);
            String sorted= new String(tmp);
            //System.out.println(sorted);
            if(map.containsKey(sorted)){
                ArrayList<String> list=map.get(sorted);
                list.add(s);
                map.put(sorted, list);
            }
            else{
                ArrayList<String> list=new ArrayList();
                list.add(s);
                map.put(sorted, list);
            }
        }
        for(Map.Entry en: map.entrySet()){
            ans.add((List)en.getValue());
        
        }
        return ans;
        
    }
}

class Visit{
    String username;
    int timestamp;
    String website;
    Visit(String username,int timestamp,String website){
        this.username=username;
        this.timestamp = timestamp;
        this.website = website;
    }
    public String toString(){
        return username+" "+timestamp+" "+website;
    }
}
class Solution {
    
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //create a array of  and sort it according to timestmap
        Visit[] visits=new Visit[username.length];
        for(int i=0;i<visits.length;i++){
            
            visits[i]=new Visit(username[i], timestamp[i], website[i]);
        }
        
        Arrays.sort(visits, new Comparator<Visit>(){
            public int compare(Visit v1, Visit v2){
                return new Integer(v1.timestamp).compareTo(v2.timestamp);
            }            
        });
        //for each user store list of websited visited
        HashMap<String, List<String>> userJourney = new HashMap<String, List<String>>();
        for(Visit v: visits){
            List<String> list=userJourney.getOrDefault(v.username, new ArrayList<String>());
            list.add(v.website);
            userJourney.put(v.username, list);
        }
        
        //for each websites visited by a perticular user create 3 sequence patterns and store occurance of those patterns in a map
        HashMap<List<String>, Integer> count = new HashMap<List<String>, Integer>();
        
        for(List<String> list: userJourney.values()){
            //create list of list of 3 sequences from this list
            Set<List<String>> thresequence = get3Sequence(list);
            for(List<String> l: thresequence)
            {
                count.put(l, count.getOrDefault(l, 0)+1);   
            }
        }
        
        List<List<String>> maxVistedWeb = new ArrayList();
        int max=0;
        for(Map.Entry<List<String>, Integer> en: count.entrySet() ){
            if(max<en.getValue()){
                maxVistedWeb.clear();
                max=en.getValue();
                maxVistedWeb.add(en.getKey());
                
            }else if(max==en.getValue()){
                maxVistedWeb.add(en.getKey());
            }
        }
        List<String> result= null;
        String o="";
        for(List<String> slist: maxVistedWeb){
            StringBuilder sb = new StringBuilder();
            
            for(String s : slist) sb.append(s+" ");
          //  System.out.println(sb.toString());
            if(o=="" || o.compareTo(sb.toString())>0)
            {
                result=new ArrayList(slist);
                o=sb.toString();
            }

        }
        return result;
        
        
    }
    public Set<List<String>> get3Sequence(List<String> list){
        Set<List<String>> output=new HashSet<List<String>>();
        
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                for(int k=j+1;k<list.size();k++){
                    List<String> l=new ArrayList<String>();
                    l.add(list.get(i));
                    l.add(list.get(j));
                    l.add(list.get(k));
                    output.add(l);
                }
            }
        }
        return output;
    }
}

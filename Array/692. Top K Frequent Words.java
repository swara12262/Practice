class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> cnt=new HashMap<String, Integer>();
        
        for(String s: words){
            cnt.put(s, cnt.getOrDefault(s, 0)+1);
        }
        
        PriorityQueue<String> heap=new PriorityQueue<String>(new Comparator<String>(){
           public int compare(String s1, String s2){
               if(cnt.get(s1).equals(cnt.get(s2)))
                   return s2.compareTo(s1);
               else
                   return cnt.get(s1) -cnt.get(s2);
           } 
        });
        
        for(String s: cnt.keySet()){
            heap.add(s);
            if(heap.size()>k){
           //  System.out.println(heap.peek());
                heap.poll();
            }
            
        }
        LinkedList<String> res=new LinkedList<String>();
        
        for(int i=0;i<k;i++)
            res.addFirst(heap.poll());
        
        return new ArrayList(res);
    }
}

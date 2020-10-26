class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        HashMap<Integer, Integer> m=sortByValue(map);
        int i=0;
        for(Map.Entry<Integer, Integer> en: m.entrySet()){
            if(i<res.length)
                res[i]=en.getKey();
            else
                break;
            i++;
            
        }
        return res;
        
    }
    HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> map){
        LinkedList<Map.Entry<Integer, Integer>> list=new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
          
            public int compare(Map.Entry<Integer, Integer> e1,Map.Entry<Integer, Integer> e2){
                return e2.getValue().compareTo(e1.getValue());
            }
        });
        
        HashMap<Integer, Integer> res=new LinkedHashMap<Integer,Integer>();
        
        for(Map.Entry<Integer, Integer> en: list){
            res.put(en.getKey(), en.getValue());
        }
        return res;
    }
}

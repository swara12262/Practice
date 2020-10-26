class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length)
            return nums;
        HashMap<Integer, Integer> count=new HashMap<Integer, Integer>();
        
        for(int i=0;i<nums.length;i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        
        PriorityQueue<Integer> heap=new PriorityQueue<Integer>(new Comparator<Integer>(){
            
            public int compare(Integer i1, Integer i2){
                return count.get(i1).compareTo(count.get(i2));    
            }
        });

        for(int n: count.keySet()){
            heap.add(n);
            if(heap.size()>k)heap.poll();
        }
        
        int[] res=new int[k];
        for(int i=k-1;i>=0 ;i--)
            res[i]=heap.poll();
        
        return res;
        
    }
}

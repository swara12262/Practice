class HitCounter {

    /** Initialize your data structure here. */
    //HashMap to store timestamp as key and no of hits at that timestamp as value
    HashMap<Integer,Integer> freq=new HashMap<Integer,Integer>();
    public HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        freq.put(timestamp, freq.getOrDefault(timestamp, 0)+1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int noOfhits=0;
        for(Map.Entry<Integer, Integer> en: freq.entrySet()){
            int key=en.getKey();
            int val=en.getValue();
            
            //if timestamp is within first 5mins 
            if(timestamp<=300 && key<=300)
                noOfhits+=val;
            else{
                //cacluate time since when 5 mins were from this timetsmp;
                int start=timestamp-300;
                if(key>start)
                    noOfhits+=val;
            }
        }
        return noOfhits;
        
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

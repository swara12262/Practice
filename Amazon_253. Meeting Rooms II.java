class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]<b[0]?-1:a[0]==b[0]?0:1;
            }
        });
        
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        
        for(int[] interval: intervals){
            minHeap.add(interval[1]);
            if(minHeap.size()!=0 && minHeap.peek()<=interval[0])minHeap.poll();         
        }    
       
        return minHeap.size();
    }
}

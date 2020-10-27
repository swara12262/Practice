class Solution {
    public int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0]<b[0]?-1:a[0]==b[0]?0:1;
            }
        });
        
        LinkedList<int[]> mergedList =new LinkedList<int[]>();
        
        for(int[] interval:intervals){
            
            //if it is not overlapping interval or mergedList is empty then simply add
            if(mergedList.isEmpty() || mergedList.getLast()[1] < interval[0])
                mergedList.add(interval);
            else{
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], interval[1]);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
        
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        //create max heap
        PriorityQueue<Integer> heap=new PriorityQueue(Comparator.reverseOrder());
       
        for(int a: stones)
            heap.add(a);
        while(heap.size()>1)
        {
            int x=heap.remove();
            int y=heap.remove();
            if(x!=y)
                heap.add(Math.abs(y-x));
        }
        if(heap.size()==1)
            return heap.remove();
        return 0;
    }
}

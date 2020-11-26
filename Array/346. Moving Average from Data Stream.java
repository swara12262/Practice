class MovingAverage {

    /** Initialize your data structure here. */
    List<Integer> list;
    int size=0;
    public MovingAverage(int size) {
        this.size=size;
        this.list =new ArrayList<Integer>();
    }
    
    public double next(int val) {
        if(list.size()>=size)
            list.remove(0);
        list.add(list.size(),val);
        int sum= 0;
        //System.out.println(size);
        for(int i: list)
        {
          //  System.out.print(i+" ");
            sum+=i;
        }
        return sum/(list.size()*1.0);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

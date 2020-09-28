class MinStack {

    Stack mainStack;
    /** initialize your data structure here. */
    public MinStack() {
        mainStack=new Stack();
    }
    
    public void push(int x) {
        mainStack.push(x);
        
    }
    
    public void pop() {
        mainStack.pop();
    }
    
    public int top() {
        return (int)mainStack.peek();
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        Iterator it=mainStack.iterator();
        while(it.hasNext())
        {
            int t=(int)it.next();
            if(t<min)
                min=t;
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

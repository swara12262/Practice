class MaxStack {

    Stack<Integer> stk;
    Stack<Integer> maxstk;
    /** initialize your data structure here. */
    public MaxStack() {
        stk=new Stack<Integer>();
        maxstk=new Stack<Integer>();
    }
    
    public void push(int x) {
        int max= maxstk.isEmpty()?x:maxstk.peek();
        maxstk.push(max>x?max:x);
        stk.push(x);
    }
    
    public int pop() {
        maxstk.pop();
        return stk.pop();
    }
    
    public int top() {
        return stk.peek();    
    }
    
    public int peekMax() {
        return maxstk.peek();
        
    }
    
    public int popMax() {
        int max=maxstk.peek();
        
        Stack<Integer> buffeer =new Stack<Integer>();
        //traverse till max element
        while(max!=top())
            buffeer.push(pop());
        
        //pop max element
        pop();
        
        //push back removed elemetns to stacks
        while(!buffeer.isEmpty())
            push(buffeer.pop());
        
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

class MyQueue {

    Stack mainStk;
    Stack sideStk;
    /** Initialize your data structure here. */
    public MyQueue() {
        mainStk=new Stack();
        sideStk=new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!mainStk.isEmpty()){
            sideStk.push(mainStk.pop());
        }
        mainStk.push(x);
        while(!sideStk.isEmpty())
        {
            mainStk.push(sideStk.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return (int)mainStk.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return (int)mainStk.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainStk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk=new Stack<Integer>();
      
        //to mark end of the stack
        stk.push(-1);
        
        int maxArea = 0;
        
        for(int i=0;i<heights.length;i++){
            
            while(stk.peek()!=-1 &&  heights[stk.peek()]>=heights[i]){
                maxArea = Math.max(maxArea, heights[stk.pop()]* (i-stk.peek()-1));
                
            }
            stk.push(i);
            
        }
    while(stk.peek()!=-1 ){
                maxArea = Math.max(maxArea, heights[stk.pop()]* (heights.length-stk.peek()-1));
                
            }
        return maxArea;
    }
}

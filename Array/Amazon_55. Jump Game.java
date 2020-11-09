class Solution {
    public boolean canJump(int[] nums) {
        //position we want to reach at the end
        int lastPosition = nums.length-1;
        
        //form backward check foreach element if we can reach lastPosition
        
        for(int i=nums.length-1;i>=0 ;i--){
            if(i+nums[i]>=lastPosition)
                lastPosition=i;
        }
        return lastPosition==0;
    }
}

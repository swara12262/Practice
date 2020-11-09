class Solution {
    public int jump(int[] nums) {
        
        int n=nums.length;
        if(n<2)return 0;
        //min jumps we need to take to reach destination
        int jumps= 1;
        //max position we can reach starting form cur index
        int maxPos= nums[0];
        
        //max steps one can take for cur jump
        int maxSteps = nums[0];
        
        for(int i=1;i<n;i++){
            //if to reach at i we dont have enough steps then we need to take one more jump
            if(maxSteps<i)
            {
                jumps++;
                maxSteps=maxPos;
            }
            maxPos=Math.max(maxPos, nums[i]+i);
        }
        return jumps;
        
    }
}

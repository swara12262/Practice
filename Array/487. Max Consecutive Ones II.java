class Solution {
    //using sliding window technique
    public int findMaxConsecutiveOnes(int[] nums) {
        int s=0;
        int e=0;
        int ans=0;
        int zerocnt=0;
        for(e=0;e<nums.length;e++){
            if(nums[e]==0)
                zerocnt++;
            //update our window to remove one zero as zero cnt is increased to greater than 1 value
            while(zerocnt>1){
                if(nums[s]==0)
                    zerocnt--;
                s++;
            }
            ans=Math.max(ans, e-s+1);
        }
        return ans;
    }
}

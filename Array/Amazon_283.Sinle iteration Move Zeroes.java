class Solution {
    public void moveZeroes(int[] nums) {
        //to iterate array 
        int i=0;
        //to keep track of non zero elements
        int j=0;
        
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0)
            {
                nums[j]=nums[i];
                j++;
            }   
        }
        while(j<nums.length){
            nums[j++]=0;
        }
        
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        
        //find first pair from end which is decrasing
        int i= nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        
        //find the first greater element that nums[i] from end
        int j=nums.length-1;
        if(i>=0 ){
            while(j>=0 && nums[j]<=nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
        
    }
    public void swap(int[] nums, int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
        
    }
    public void reverse(int[] nums, int s){
        int i=s, j=nums.length-1;
        while(i<j){
            swap(nums, i, j);
            i++;j--;
        }
    }
}

class Solution {
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.nums=nums;
        return quickSelect(0, nums.length-1, nums.length-k);
    }
    public int quickSelect(int left, int right, int k_smallest){
        if(left==right)return nums[left];
        
        Random rand_no=new Random();
       
        int random_index=left + rand_no.nextInt(right-left);
        int pivot_index = partition(left, right, random_index);
        
        if(k_smallest==pivot_index)
            return nums[pivot_index];
        else if(k_smallest <pivot_index)
            return quickSelect(left, pivot_index-1, k_smallest);
        
            return quickSelect( pivot_index+1,right, k_smallest);
    
    }
    public int partition(int left, int right, int random_index){
        int pivot= nums[random_index];
            
        int tmp=nums[random_index];
        nums[random_index]=nums[right];
        nums[right]=tmp;
        
        int i=left;
        //partition around last eleemt in the array
        for(int j=left;j<=right;j++){
            if(nums[j]<pivot)
            {
                //swap i and right
                tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
                i++;    
            }
        }
        //swap i and right
        tmp=nums[i];
        nums[i]=nums[right];
        nums[right]=tmp;
        
        return i;
    }
}

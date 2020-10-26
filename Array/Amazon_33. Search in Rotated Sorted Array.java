class Solution {
    int[] nums;
    int n;
    public int search(int[] nums, int target) {
        this.nums=nums;
        this.n=nums.length;
        
        if(n==0)return -1;
        
        if(n==1)
           return nums[0]==target? 0: -1;
        
        //find rotation_index 
        int rotation_index=find_rotation_index(0, n-1);
        System.out.print(rotation_index);
        if(rotation_index==0)
           return search(0, n-1, target);
        
        if(target<nums[0])
            return search(rotation_index,n-1, target);
        return search(0, rotation_index, target);
        
        
        
    }
    public int search(int left, int right, int target){
        while(left<=right){
            int pivot = (left+right)/2;
            if(nums[pivot]==target)return pivot;
            if(nums[pivot]>target)
                right=pivot-1;
            else
                left=pivot+1;
            
        }
        return -1;
    }
    int find_rotation_index(int left, int right){
        if(nums[left]<nums[right])return 0;
        
        while(left<=right){
            int pivot = (left+right)/2;
            
            if(nums[pivot]>nums[pivot+1])
                return pivot+1;
            else{
                if(nums[left]>nums[pivot])
                    right=pivot-1;
                else
                    left=pivot+1;
            }
            
        }
        return 0;
    }
}

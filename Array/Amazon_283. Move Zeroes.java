class Solution {
    public void moveZeroes(int[] nums) {
        int[] ans=new int[nums.length];
        int j=nums.length-1;
        int k=0;
        for(int i=0;i<nums.length && k<=j;i++){
            if(nums[i]==0)
            {
                ans[j]=0;
                j--;
            }
            else{ 
                ans[k]=nums[i];
                k++;
            }

        }
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
            nums[i]=ans[i];
        }
    }
}

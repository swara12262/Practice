class Solution {
    public int threeSumClosest(int[] nums, int t) {
        
        Arrays.sort(nums);
        
        int closet=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int h=nums.length-1;
            
            while(l<h){
                int sum=nums[l]+nums[i]+nums[h];
                if(Math.abs(t-sum)<Math.abs(closet))
                    closet=t-sum;
                if(sum<t)
                    l++;
                else 
                    h--;
            }
        }
        return t-closet;
        
    }
}

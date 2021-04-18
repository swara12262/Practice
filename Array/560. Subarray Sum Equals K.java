public class Solution {
    public int subarraySum(int[] nums, int k) {
        int res= 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=nums.length;j++){
                int sum  = 0; 
                //subarray starting with i and ending with j
                for(int l=i;l<j;l++){
                    sum+=nums[l];

                }
                    if(sum==k){
                        res++;
                        
                    }
            }
        }
        return res;
    }
}

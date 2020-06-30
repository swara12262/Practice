class Solution {
    public int findNumbers(int[] nums) {
        int cnt=0;
        for(int i=0;i<nums.length;i++)
        {
            if(computeDigits(nums[i])%2==0)
                cnt++;
        }
        return cnt;
        
    }
    public int computeDigits(int n)
    {
        int cnt=0;
        while(n>0)
        {
            cnt++;
            n=n/10;
        }
        return cnt;
    }
}

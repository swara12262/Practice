class Solution {
    public int[] runningSum(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        map.put(0, nums[0]);
        int[] out=new int[nums.length];
        out[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            out[i]=map.get(i-1)+nums[i];
            map.put(i, map.get(i-1)+nums[i]);
            
        }
        return out;        
        
    }
}

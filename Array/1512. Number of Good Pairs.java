class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        int cnt=0;
        for(Map.Entry en:map.entrySet())
        {
            int n =(int)en.getValue();
            cnt+=(n*(n-1))/2;
        }
        return cnt;
    }
}

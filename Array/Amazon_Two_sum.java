class Solution {
    public int[] twoSum(int[] nums, int t) {
        int[] res=new int[2];
        HashMap<Integer, Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            int val=t-nums[i];
            if(map.containsKey(val))
            {
                res[0]=(int)map.get(val);   
                res[1]=i;
                break;
            }
            else
                map.put(nums[i], i);
           
        }
        return res;
    }
}

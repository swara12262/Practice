class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     
        List<List<Integer>> res=new ArrayList();
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++)
        {
            int l=i+1, h=nums.length-1;
            if(i>0 && nums[i]==nums[i-1])continue;
            int sum=-nums[i];
          
            while(l<h){
                if(sum>nums[l]+nums[h])
                    l++;
                else if(sum<nums[l]+nums[h])
                    h--;
                else
                {
                    
                    ArrayList<Integer> list=new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[h]);
                    res.add(list);
                    l++;
                    h--;
                    while(l<h && nums[l]==nums[l-1])l++;
                }
            }
    }
    return res;
        
      
        
        
    }
}

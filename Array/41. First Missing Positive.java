class Solution {
    public int firstMissingPositive(int[] nums) {
   
        List<Integer> list = new ArrayList<>(nums.length);
 
        for (int i: nums) {
            list.add(Integer.valueOf(i));
        }
 
        int largest = Collections.max(list);  
        int small   = Collections.min(list);
        if(small!=1 && small!=0 && !list.contains(1))return 1;
    while(small!=largest){
        if(small>0 && !list.contains(small))     return small;
        small++;
     }
        return largest+1;
    }
}

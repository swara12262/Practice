class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr=new int[60];
        int result=0;
        
        for(int i=0;i<time.length;i++){
            int mod= time[i]%60; // for 30 mod is 3
            int targetMod= (60-mod)%60; //for 150 mod is 3
            result+=arr[targetMod];
            arr[mod]++;
        }
        return result;
    }
}

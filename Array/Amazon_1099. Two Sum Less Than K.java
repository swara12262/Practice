class Solution {
    public int twoSumLessThanK(int[] a, int k) {
     
        int maxSum = -1;
        Arrays.sort(a);
        int i=0,j=a.length-1;
        
        while(i<j){
            if(a[i]+a[j]<k){
                maxSum=Math.max(maxSum, a[i]+a[j]);
                i++;
            }
            else
                j--;
        }
        return maxSum;
    }
}

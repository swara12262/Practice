class Solution {
    public int[] sortArrayByParity(int[] a) {
     
        int k=0, l=a.length-1;
        while(k<l){
            if(a[k]%2> a[l]%2){
                int tmp=a[k];
                a[k]=a[l];
                a[l]=tmp;
            }
            if(a[k]%2==0)k++;
            if(a[l]%2==1)l--;
        }
        return a;
    }
}

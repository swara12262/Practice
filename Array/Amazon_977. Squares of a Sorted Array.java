class Solution {
    public int[] sortedSquares(int[] a) {
        //i to traverse negative no.
        //j to traverse positive nos.
        //k to tarvser ans array
        int i=0,j=0,k=0;
        
        int n = a.length;
        
        int[] ans=new int[n];
        
        //tarverse the array till negative numbers
        while(j<n && a[j]<0)
            j++;
        //i will point to negative numbers
        i = j-1;
        
        while(i>=0  && j<n){
            int isq= a[i]*a[i];
            int jsq= a[j]*a[j];
            
            if(isq<jsq){
                ans[k]=isq;i--;k++;
            }else{
                ans[k]=jsq;j++;k++;
            }
        }
        while(i>=0){
            int isq= a[i]*a[i];
            ans[k]=isq;i--;k++;
        }
        while(j<n){
            int jsq= a[j]*a[j];
            ans[k]=jsq;j++;k++;
        }
        return ans;
        
    }
}

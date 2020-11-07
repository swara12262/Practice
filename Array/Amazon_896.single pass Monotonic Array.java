class Solution {
    public boolean isMonotonic(int[] a) {
        boolean incresing = true;
        boolean decresing = true;
        for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1])incresing=false;
            if(a[i]<a[i+1])decresing =false;
        }
        return decresing || incresing  ;
        
    }
    
   
}

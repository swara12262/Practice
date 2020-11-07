class Solution {
    public boolean isMonotonic(int[] a) {
        return increasing(a) || decreasing(a);
        
    }
    public boolean increasing(int[] a){
        for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1])return false;
        }
        return true;
    }
    public boolean decreasing(int[] a){
        for(int i=0;i<a.length-1;i++){
            if(a[i]<a[i+1])return false;
        }
        return true;
    }
    
}

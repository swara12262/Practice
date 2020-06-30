class Solution {
    public int[] sortedSquares(int[] a) {
        int[] out=new int[a.length];
        
        int j=0;
        for(int i=0;i<a.length;i++)
        {
            int sq=a[i]*a[i];
            j=i-1;
            while(j>=0 && out[j]>sq)
            {
                out[j+1]=out[j];
                j--;
            }
            out[j+1]=sq;
            
        }
        return out;
    }
}

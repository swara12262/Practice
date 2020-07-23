class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] tmp=new int[m+n];
        int l=tmp.length;
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]>nums2[j]){
                tmp[k]=nums2[j];
                j++;
            }
            else{
                tmp[k]=nums1[i];
                i++;
            }
            k++;
        }
        while(i<m){
            tmp[k]= nums1[i];
            i++;k++;
        }
         while(j<n){
            tmp[k]= nums2[j];
             j++;k++;
        }
        int mid=l/2;

        //System.out.println(tmp[mid]+" "+tmp[mid-1]);
        if(l%2==0)
            return ((tmp[mid]+tmp[mid-1])/2.0);
        return tmp[mid]*1.0;
    }
}

class Solution {
    public int search(int[] a, int target) {
        int left=0;
        int right=a.length-1;
        
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(a[mid]==target)return mid;
            
            //if 0 to mid-1 array is non rotated
            if(a[mid]>=a[left])
            {
                if(target>=a[left] && target<a[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
            else //if(a[mid]<a[left])
            {
                if(target<=a[right] && target>a[mid])
                    left=mid+1;
                else
                    right=mid-1;
            }
                
        }
        return -1;
        
    }
}

class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int l=0, h=height.length-1;
        while(l<h){
          max=Math.max(max, Math.min(height[l], height[h])*(h-l));
            if(height[l]<height[h])
                l=l+1;
            else
                h=h-1;
        }
        return max;
    }
}

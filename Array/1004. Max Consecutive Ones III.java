class Solution {
    public int longestOnes(int[] a, int k) {
        int s=0,e=0,zerocnt=0,ans=0;
        
        for(e=0;e<a.length;e++){
            if(a[e]==0)
                zerocnt++;
            
            //to udapte the window
            while(zerocnt>k){
                if(a[s]==0)
                    zerocnt--;
                s++;
            }
            ans=Math.max(ans, e-s+1);
        }
        return ans;
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int L = 1;
        int R = 1;
        
        // get max 
        for(int i : piles)
        {
            R = Math.max(R, i);
        }
        
        int K = Integer.MAX_VALUE;
        while(L <=R)
        {
            int mid = L + (R-L)/2;
            int time = getTime(mid, piles);
            if(time <= H)
            {
                K = Math.min(K, mid);
                R = mid-1;
            }
            else
            {
                L = mid+1;
            }
        }
        return K;
    }
    public int getTime(int K, int[]piles)
    {
        int time = 0;
        for(int i :  piles)
        {
            time +=Math.ceil((double)i/K);
        }
        return time;
    }
}

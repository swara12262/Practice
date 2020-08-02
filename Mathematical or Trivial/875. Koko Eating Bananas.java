class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        long total=0;
        for(int i: piles)
            total+=i;
        long min=total/H;
       if(min==0)return 1;
        while(!ifKokoEatsAllBananas(piles, min, H))min++;
        return (int)min;
    }
    boolean ifKokoEatsAllBananas(int[] a, long min, int h){
         int time = 0;
        for (int i: a)
            time+=(i-1)/min+1;
        return time <= h;
    }
}

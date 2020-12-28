class Solution {
    public int minCostToMoveChips(int[] position) {
 
        int odd_cnt = 0;
        int even_cnt = 0;
        for(int i:  position){
            if(i%2==0)even_cnt++;
            else
                odd_cnt++;
        }
        return Math.min(even_cnt, odd_cnt);
    }
}

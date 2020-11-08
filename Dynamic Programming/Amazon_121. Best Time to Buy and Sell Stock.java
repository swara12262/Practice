class Solution {
    public int maxProfit(int[] prices) {
        //store min price till this point and calulate max at each stage and update if it max
        if(prices.length==0)return 0;
        int maxProfit=0;
        int minPrice= prices[0];
        
        for(int i=1;i<prices.length;i++){
            
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] -minPrice);
        }
        return maxProfit;
    }
}

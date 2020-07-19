class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res=numBottles;
        int rem=0,div=0;
        if(numExchange>numBottles)
            return numBottles;
        while(numBottles>=numExchange)
        {
            div=numBottles/numExchange;
            rem=numBottles%numExchange;
            res+=div;
            div+=rem;
            numBottles=div;
        }
        
        return res;
       
        
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        /*
        I'll use a greedy approach. 
        Since I can trade unlimited times with no fee, I just capture every price increase 
        — whenever tomorrow's price is higher than today's, I add the difference to my profit.
        */
        if(prices.length <= 1) return 0;

        int res = 0;
        // Because on the last day, there's no next day to sell to, so no further profit is possible.
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < prices[i + 1]){
                res += prices[i + 1] - prices[i];
            }
        }

        return res;
    }
}
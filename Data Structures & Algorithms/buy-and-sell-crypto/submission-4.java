class Solution {
    public int maxProfit(int[] prices) {
        // 因为 choose a day to buy and choose another day sell
        // max profit
        // treat each day as a sell day, keep track of the current lowest price
        // update the profit
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}

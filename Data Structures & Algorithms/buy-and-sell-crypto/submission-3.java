class Solution {
    public int maxProfit(int[] prices) {
        /*
        keep track of the minimum price seen so far
        for each day, get the profit using cur price - minimum price
        keep track of the maximum profit
        */
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}

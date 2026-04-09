class Solution {
    public int maxProfit(int[] prices) {
        // greedy
        // For each day, if we sell on that day, 
        // the best profit comes from buying at the minimum price seen before that day.
        // So we scan the array once while keeping track of the minimum price so far 
        // and updating the maximum profit.
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}

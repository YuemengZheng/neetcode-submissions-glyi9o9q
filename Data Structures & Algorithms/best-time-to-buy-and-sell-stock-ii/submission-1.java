class Solution {
    public int maxProfit(int[] prices) {
        // use dp to get the best time buy and sell stock
        // everyday has two state: hold the stock or not hold the stock
        // max profit for holding the stock 
        // => max(yestoday hold the stock today still hold, yestoday not hold the stock today buy the stock)
        // max profit for not holding the stock
        // => max(yestoday not hold the stock and today still not hold, yestoday hold the stock today sell the stock)
        // the final answer is the max profit at the last day when we do not hold the stock
        if(prices.length <= 1) return 0;

        int hold = -prices[0];
        int notHold = 0;

        for(int i = 1; i < prices.length; i++){
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, hold + prices[i]);
        }

        return notHold;
    }
}
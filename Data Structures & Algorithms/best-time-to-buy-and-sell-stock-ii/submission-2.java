class Solution {
    public int maxProfit(int[] prices) {
        /*
        High Level
        "I'll use dynamic programming. 
        Each day, I track two states: the maximum profit when I'm holding the stock, 
        and the maximum profit when I'm not holding it. I update both states as I go through the prices, 
        and the final answer is the profit on the last day when I'm not holding any stock."

        Main Steps
        "I track two states for each day:
        Holding the stock — the max profit if I'm holding at the end of the day. 
        It's the better of two choices: I was already holding from yesterday and keep it, or I wasn't holding and buy today.
        Not holding the stock — the max profit if I'm not holding. 
        Again two choices: I wasn't holding yesterday and stay out, or I was holding and sell today.
        I update both states each day. 
        At the end, I return the 'not holding' state, because holding a stock means the profit is still locked in it 

        initialize: 
        hold = -prices[i]
        nothold = 0

        for each day
        hold = max(hold, nothold - prices[i])
        nothold = max(nothold, hold + prices[i])

        final answer = the profit on the last day when not holding any stock
        */
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
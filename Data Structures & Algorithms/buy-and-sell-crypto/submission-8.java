class Solution {
    public int maxProfit(int[] prices) {
        /*
        I treat each day as a potential selling day 
        and keep track of the cheapest buying price seen so far.
        At each position, I calculate the profit if I sell today 
        and update the maximum profit.
        */
        // TIME: O(n)
        // SPACE: O(1)
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}

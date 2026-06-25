class Solution {
    public int maxProfit(int[] prices) {
        // 可以多次买卖，max profit = 当明天的价格比今天的价格高，我就在今天买入，明天卖出

        if(prices.length <= 1) return 0;

        int res = 0;
        // 不断对比今天和明天的价格，寻找买入和买出
        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < prices[i + 1]){
                res += prices[i + 1] - prices[i];
            }
        }
        
        return res;
    }
}
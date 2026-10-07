class Solution {
    public int maxProfit(int[] prices) {
        // try to find the lowerest price and find the largest price that after the lowest price
        // when we meet a lower price try to update the lowerest price, reset largest price to lowerest price
        // otherwise update largest price and update the global max
        int max = 0;
        int buy = Integer.MAX_VALUE;
        for(int p : prices) {
            // buy = Math.min(buy, p);
            max = Math.max(p - buy, max);
            buy = Math.min(buy, p);
        }
        return max;
    }
}

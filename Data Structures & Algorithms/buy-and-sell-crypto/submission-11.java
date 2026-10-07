class Solution {
    public int maxProfit(int[] prices) {
        // try to find the lowerest price and find the largest price that after the lowest price
        // when we meet a lower price try to update the lowerest price, reset largest price to lowerest price
        // otherwise update largest price and update the global max
        int max = 0;
        int buy = Integer.MAX_VALUE;
        int sell = Integer.MIN_VALUE;
        for(int p : prices) {
            if(p < buy) {
                buy = p;
                sell = p;
            } else {
                sell = Math.max(sell, p);
            }
            max = Math.max(sell - buy, max);
        }
        return max;
    }
}

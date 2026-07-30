class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // weight capacity is inversely related with the time needed to ship all the packages
        // capacity range => max(weights), sum(weights)
        int l = 0;
        int r = 0;
        for(int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int time = getDays(weights, mid);
            if(time <= days) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    /*
    To calculate the days for a given capacity: I initialize res to 1, 
    since we always need at least one day, and cur to 0, to track the current day's load. 
    Then for each weight, if adding it still fits within capacity, I add it to cur. 
    Otherwise, today is full, so I increment res and reset cur to this weight, starting a new day.
    */
    private int getDays(int[] weights, int capacity) {
        int res = 1;
        int cur = 0;
        for(int w : weights) {
            if(cur + w <= capacity) {
                cur += w;
            }else {
                res++;
                cur = w;
            }
        }
        return res;
    }
}
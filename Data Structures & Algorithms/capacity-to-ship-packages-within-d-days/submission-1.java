class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // use binary search to get the least weight capacity that can ship all the 
        // packages within days days

        // get the range of the weight
        int max = 0;
        int sum = 0;
        for(int w : weights){
            max = Math.max(w, max);
            sum += w;
        }

        int l = max;
        int r = sum;
        while(l <= r){
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
    private int getDays(int[] weights, int capacity) {
        int days = 0;
        int i = 0;
        while(i < weights.length) {
            int sum = 0;
            while(i < weights.length && sum + weights[i] <= capacity) {
                sum += weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
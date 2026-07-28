class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        I'll use binary search on the eating speed 
        to find the minimum speed such that the total time to 
        finish all piles is within h hours.
        */
        // ***** TIME: O(log(maxPile) * n), SPACE:O(1) *****
        int left = 1, right = 1000000000;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long time = getTime(piles, mid);
            if(time <= h){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private long getTime(int[] piles, int speed){ // 10^12可以考虑用long
        int res = 0;
        for(int pile : piles){
            res += pile / speed;
            if(pile % speed > 0){
                res++;
            }
        }
        return res;
    }
}

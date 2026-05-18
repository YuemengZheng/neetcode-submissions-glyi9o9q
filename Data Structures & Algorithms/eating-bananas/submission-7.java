class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        We use binary search on the eating speed.
        For a given speed, we can calculate the total time needed to finish all piles.
        If the time is within h, we try a smaller speed; otherwise, we increase the speed.
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

    private long getTime(int[] piles, int speed){
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

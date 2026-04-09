class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 题目求：在h小时之内吃完所有香蕉的最慢的速度
        // 对于速度的范围：1 到 max of piles
        // 速度和时间的关系是相反的，当我们知道速度，我们可以得到时间
        // 再拿时间和我们要求的h小时做对比，如果时间短了，我们可以速度慢一点
        // 时间长了，我们可以速度快一点
        // 如果时间一致，我们可以放慢速度，追求最慢的速度但是任然符合要求
        // ***** TIME: O(log(maxPile) * n), SPACE:O(1) *****
        int max = 0;
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        int left = 1, right = max;
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

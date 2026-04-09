class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 题目在求什么： 可以在h小时之内吃完所有香蕉的最小速度
        // 因为我们一个小时内最多只能吃一个pile的香蕉，所以我们这里有限制，速度的最大是max(piles),最小是1根一个小时
        // 所以符合条件的速度是1 - max(piles)，暴力解法是从小到大去尝试，计算时间和h比较
        // 我们可以用 binary search 优化这个过程，使得max * n的时间 下降到 logmax * n
        // ***** TIME: O(logmax * n), SPACE:O(1) *****
        int n = piles.length;
        int max = 0;
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        int l = 1, r = max;
        int res = 0;
        while(l <= r){ // <=
            int mid = l + (r - l) / 2;
            long timeNeed = 0L;
            for(int pile : piles){
                timeNeed += (pile + mid - 1) / mid;
            }
            if(timeNeed <= h){
                r = mid - 1;
                res = mid;
            }else{
                l = mid + 1;
            }
        }
        return res;
    }
}

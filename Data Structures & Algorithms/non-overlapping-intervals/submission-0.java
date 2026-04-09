class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // We want to remove the minimum number of intervals 
        // so that the remaining intervals do not overlap.
        // A greedy strategy works well here.
        // sort intervals by their start time, we process them from left to right 
        // when overlap occurs, keep the interval that end earlier
          // leave more room for future intervals

        // 1. Sort the intervals by their start time.
        // 2. initialize:
            // preEnd => end of the prev interval
            // cnt => count how many intervals to remove

        // 3. iterate the intervals
        // 4. for each interval
            //  if start >= preEnd => no overlap, update the prevEnd = end
            //  else overlap => cnt++,keep the interval with samller end, preEnd = min(preEnd, end)
        // 5. return cnt

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int preEnd = Integer.MIN_VALUE;
        int cnt = 0;
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(start >= preEnd){
                preEnd = end;
            }else{
                cnt++;
                preEnd = Math.min(preEnd, end);
            }
        }
        return cnt;
    }
}

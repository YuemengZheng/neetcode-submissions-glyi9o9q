/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // We want to find the minimum number of meeting rooms required so that no meetings overlap
        // Instead of tracking whole intervals, we can separate the problem into two simpler timelines
        // one list of all start times
        // one list of all end times
            // whenever a meeting starts before another one ends, we need a new room
            // whenever a meeting ends before or at the same time another starts, a room becomes free
        // By moving two pointers over the sorted start and end times, we can track how many meetings are happening at the same time.
        // return maximum number of rooms needed

        // 1. Create two arrays, to store start time and end time, sort them
        // 2. two pointers for start and end arrays, count = 0, res = 0
        // while there are still start time to process:
        // if start < end, count++
        // else count-- e++, count++ s++
        // update the res
        // return res
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0, cnt = 0, s = 0, e = 0;
        while(s < n){
            if(start[s] < end[e]){
                s++;
                cnt++;
                res = Math.max(res, cnt);
            }else{
                e++;
                cnt--;
            }
        }
        return res;
    }
}

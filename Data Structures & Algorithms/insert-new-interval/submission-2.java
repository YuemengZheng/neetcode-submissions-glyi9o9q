class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 三种情况
        // oldend < newstart => 前面部分
        // oldstart >= newend => while 重叠部分 minstart maxend 
        // oldstart > newend => 后面部分
        int n = intervals.length, i = 0;
        List<int[]> res = new ArrayList<>();
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        // 如果oldend >= newstart，会把第三部分的也混淆进来
        // The mistake will treat intervals that start after newInterval ends
        // as overlapping intervals.
        while(i < n && intervals[i][0] <= newInterval[1]){//!!
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i < n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}

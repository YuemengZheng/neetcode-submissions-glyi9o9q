class Solution {
    public int[][] merge(int[][] intervals) {
        // sort the array by the starting index
        // *********TC: O(nlog), SC: O(1)*********
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            int lastEnd = res.get(res.size() - 1)[1];
            if(start <= lastEnd){
                res.get(res.size() - 1)[1] = Math.max(lastEnd, end);
            }else{
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[res.size()][]);
        
    }
}

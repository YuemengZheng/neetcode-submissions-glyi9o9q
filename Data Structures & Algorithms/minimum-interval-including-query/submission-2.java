class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // brute force, handle quries one by one
        // for each query, scan through the sorted intervals
        // whenever an interval covers the query, compute its length r - l + 1
        // keep the min length seen => n * q
        // 有重复的工作，如果有后面的query落在一样的区间，其实数据是可以重复利用的
        // 因为我们一直在要得到min interval，所以我们思考用minHeap，ordered by interval length 
        // 而且我们需要把queries 和 intervals sort,这样才能重复利用之前的数据
        // for each query, 
        // add intervals whose start ≤ q
        // remove all the intervals ends before start
        // the smallest valid is always the top of min heap
        // this way 

        // Sort intervals by their start value.
        // Sort the queries, but also keep their original order for the final answer.
        // while interval.end < q, add to the min heap
        // while heap is not empty and top interval'end < q, remove
        // while heap is not empty and top interval'end >= q, this is answer
        // return res

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b [0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int n = queries.length;
        int[][] sortedQueries = new int[n][2];
        for(int i = 0; i < n; i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        int[] res = new int[n];
        int i = 0;
        for(int[] query : sortedQueries){
            int q = query[0];
            int index = query[1];

            // add all intervals whose start <= q
            while(i < intervals.length && intervals[i][0] <= q){
                int start = intervals[i][0];
                int end = intervals[i][1];
                int length = end - start + 1;
                minHeap.offer(new int[]{length, end});
                i++;
            }
            // remove all the intervals that cannot cover q
            while(!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }
            // the top of heap is the answer 
            if(minHeap.isEmpty()){
                res[index] = -1;
            }else{
                res[index] = minHeap.peek()[0];
            }
        }
        return res;
    }
}

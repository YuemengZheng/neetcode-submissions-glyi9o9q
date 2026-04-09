class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // the k closest points
        // use max-heap of k size
        // the heap always keeps the k closest points found so far
        // the point with the largest distance sits at the top
        // when a new pointer is closer than the top point,
        //  we remove the farthest, and insert the new one
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(getDistance(b), getDistance(a)));
        
        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        while(k > 0){
            res[--k] = maxHeap.poll();
        }
        return res;
    }
    // getDistance -> return int
    private int getDistance(int[] a){
        int res = 0;
        res += a[0] * a[0] + a[1] * a[1];
        return res;
    }
}

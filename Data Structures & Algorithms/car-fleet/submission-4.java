class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // The key idea of this problem is to determine whether a car behind 
        // can catch up to the car or fleet in front before reaching the target.
        // We can turn the problem into counting how many distinct fleets are formed 
        // based on these arrival times.
        // ***** TIME: O(nlogn), SPACE:O(n) *****
        
        // 将position和speed组合在一起，并按照position有大到小排序
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        // 用一个prevTime记录当前车队的抵达终点的时间
        double prevTime = 0.0;
        int res = 0;
        // loop through整个array，如果当前到达终点所需要的时间 <= prevTime,可以并入这个车队
        // else 新增一个车队，并更新车队的速度
        for(int[] car : cars){
            double time = (double)(target - car[0]) / car[1];
            if(time > prevTime){
                res++;
                prevTime = time;
            }
        }
        return res;
    }
}

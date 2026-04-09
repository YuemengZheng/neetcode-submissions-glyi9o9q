class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // 本质在看后面的车能不能在到达终点前和前面的车形成车队
        // 因为后面的车在追赶上前面的车后，是按照前面的车速
        // 所以我们本质上在求能分成几个时间段到达终点
        // 首先离终点最近的车肯定是从头到尾按照自己的速度走，它一定是可以形成一个车队的
        // 所以我们将车辆按照距离终点的距离进行排序，距离越近的放前面
        // 然后进行遍历数组
        // 当我们遇到了当前车辆到达终点所需要的时间<= 当前车队的时候，可以并入这个车队
        // 否则成立一个新的车队，后面的车肯定最多只能并入这个新车队了
        // 最后返回车队数量
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

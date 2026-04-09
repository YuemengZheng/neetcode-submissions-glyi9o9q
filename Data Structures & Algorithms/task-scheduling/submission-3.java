class Solution {
    public int leastInterval(char[] tasks, int n) {
        // max-heap + cooldown queue 的核心原因其实只有一句话：
        // 因为我们每一轮都想选：当前可以执行的任务里，剩余次数最多的那个
        // 原因是剩余次数最多的任务最难安排，越早处理越不容易在后面产生很多 idle。
        // 所以我们需要一个结构，能一直快速拿到“剩余次数最多”的任务：这就是 max heap
        // 但是一个任务执行完以后，不能立刻再执行，还要冷却 n 个单位时间。
        // 所以我们还需要另一个结构记录：这个任务还剩多少次，它什么时候可以重新回到 heap
        // 所以需要queue
        // *********TC: O(n) => nlog26, SC: O(1) => 26 *********
        //统计frq，放进maxHeap
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int count : freq){
            if(count > 0){
                maxHeap.offer(count);
            }
        }
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;
        // 当还存在未处理的letter
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            // 1. time + 1
            time++;
            // 2. check有没有完成冷却的，可以放进maxheap
            if(!cooldown.isEmpty() && cooldown.peek()[1] == time){
                maxHeap.offer(cooldown.poll()[0]);
            }
            // 3.取most freq, cooldown
            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll();
                count--;
                if(count > 0){
                    cooldown.offer(new int[]{count, time + n + 1});
                }
            }
            
        }
        return time;
    }
}

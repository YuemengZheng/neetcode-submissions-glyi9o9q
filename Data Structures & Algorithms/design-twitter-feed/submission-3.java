class Twitter {
    // 有两类信息：
    // 1. 谁关注了谁
    // 2. 谁发了什么tweet，tweet要有先后顺序
    // 自然想到两个map去储存，然后逐步优化
    // 1. Map<Integer, Set<Integer>> followMap，不能重复关注，unfollow的时候方便寻找，用set储存关注人
    // 2. Map<Integer, List<int[]>> tweetMap，需要可以比较发布的先后，我们用count表示每个tweet的发布时间
    // 用list储存int[]{count, tweetId}
    // 我们用maxHeap + K-way merge来找出最新的10个
    // 先把所有的list的最后一个放进maxheap，弹出是最新的，然后把那个list的倒数第二个加入heap
    // 直到拿到10个最新的


    private int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        count = 0; // 记入时间
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);//self

        // 拿到followee的id
        for(int followeeId : followMap.get(userId)){
            // 每个id找对应的tweets，将最后一个加入heap
            if(tweetMap.containsKey(followeeId)){
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});// followeeId, index方便追踪
            }
        }
        while(!maxHeap.isEmpty() && res.size() < 10){
            int[] cur = maxHeap.poll();
            res.add(cur[1]);

            int followeeId = cur[2];
            int index = cur[3];

            if(index > 0){
                int[] prevTweet = tweetMap.get(followeeId).get(index - 1);
                maxHeap.offer(new int[]{prevTweet[0], prevTweet[1], followeeId, index - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.get(followerId).contains(followeeId)){
            followMap.get(followerId).remove(followeeId);
        }
        
    }
}

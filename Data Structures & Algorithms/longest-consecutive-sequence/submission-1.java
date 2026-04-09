class Solution {
    public int longestConsecutive(int[] nums) {
        // 找最长的连续sequence，不在乎original order
        // 要用n的time去解决，每个num最多只能被处理一次
        // 先用set记录num
        // 对于每一个num，我们只关注它是否是起点，如果是起点，我们往后扩展到底，记录len
        // 不是起点，我们先不处理，所以每个连续的序列只会被完整遍历一遍
        // set有帮我们去重
        // ***** TIME: O(n), SPACE:O(n) *****
        // Set<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // int maxLen = 0;
        // for(int num : nums){
        //     if(!set.contains(num - 1)){
        //         int curNum = num;
        //         int curLen = 1;
        //         while(set.contains(curNum + 1)){
        //             curNum++;
        //             curLen++;
        //         }
        //         maxLen = Math.max(maxLen, curLen);
        //     }
        // }
        // return maxLen;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int curLen = 1;
                int start = num;
                while(set.contains(++start)){
                    curLen++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}

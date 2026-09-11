class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        For this problem, I'll use bucket sort
        First, build a HashMap to count the frequency of each element. 
        Then I'll build a bucket array where the index represents the frequency 
        and each bucket stores all elements with that frequency. 
        For each element, I add it to the corresponding bucket according to its frequency. 
        Finally, I iterate through the array from right to left and collect the k elements.
        Time: O(n), Space: O(n).
        */

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // the maximum frequency can be n, create n + 1 buckets
        // many elements may share the same freq, use a list to store all the elements with that freq
        List<Integer>[] buckets = new List[nums.length + 1]; // ERROR1
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){// ERROR2
            int num = entry.getKey();// ERROR3
            int cnt = entry.getValue();
            if(buckets[cnt] == null){
                buckets[cnt] = new ArrayList<>();
            }
            buckets[cnt].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = buckets.length - 1; i >= 0 && index < k; i--){// ERROR4
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    res[index++] = num;
                    if(index == k)break;
                }
            }
        }
        return res;
    }
}

// time: O(n)
// space: O(n)

// if use min heap => nlogk | n + k

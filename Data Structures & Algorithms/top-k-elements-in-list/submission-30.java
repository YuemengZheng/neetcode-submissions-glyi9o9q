class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        Is k always between 1 and the number of distinct elements?

        For this problem, I'll use a min-heap to get the top k frequent elements. 
        First, I'll count the frequency of each element using a HashMap, 
        then initialize a min-heap of size k. 
        Next, I'll iterate through the frequency map and add each element to the heap. 
        Whenever the heap size exceeds k, I'll remove the element with the smallest frequency. 
        The remaining k elements in the heap are the answer. 
        The time complexity is O(n log k) and space complexity is O(n). 
        We can optimize this further using bucket sort to achieve O(n) time complexity.
        */
        
        Map<Integer, Integer> cnts = new HashMap<>();
        for(int num : nums){
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        /*
        I'll initialize a min-heap that stores each element along with its frequency, ordered by frequency. 
        Then for each entry in the frequency map, I'll add it to the heap, and if the heap size exceeds k,
        I'll poll the element with the smallest frequency
        */
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));// compare
        for(Map.Entry<Integer, Integer> entry : cnts.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll()[0];
        }
        return res;

        /*
        Example: nums = [1,1,1,2,2,3], k = 2
        First, I count frequencies: 1 appears 3 times, 2 appears 2 times, 3 appears 1 time. 
        Now I initialize an empty min-heap. 
        I iterate through the frequency map. 
        I add 1 with frequency 3 to the heap. 
        Then I add 2 with frequency 2 to the heap. 
        Now the heap has 2 elements, which equals k, so I don't remove anything. 
        Next I add 3 with frequency 1. Now the heap size is 3, which exceeds k, 
        so I poll the smallest frequency element, which is 3 with frequency 1. 
        Now the heap contains 1 and 2, which are the top 2 frequent elements. So the answer is [1, 2]."
        */
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /*
        High Level:
        "I'll use Boyer-Moore voting to get two candidates, since at most two elements can appear more than n/3 times. 
        n over three" 或 "n divided by three
        There are two passes — first find two candidates, then verify them, because the voting alone doesn't guarantee they qualify."

        Steps:
        in the first pass, I keep two candidates and their counts. If a number matches a candidate, I increment it; 
        if a candidate slot is empty, I fill it; 
        otherwise I decrement both counts. 
        
        In the second pass, I recount both candidates and keep only those appearing more than n/3 times."
    
        复杂度:
        O(n) time, O(1) space.
        */
        List<Integer> res = new ArrayList<>();
        int candidate1 = 1000000001;
        int candidate2 = 1000000001;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == candidate1) {
                cnt1++;
            }else if(nums[i] == candidate2) {
                cnt2++;
            }else if(cnt1 == 0){
                candidate1 = nums[i];
                cnt1 = 1;
            }else if(cnt2 == 0){
                candidate2 = nums[i];
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == candidate1) {
                cnt1++;
            }else if(nums[i] == candidate2) {
                cnt2++;
            }
        }

        if(cnt1 > nums.length / 3) res.add(candidate1);
        if(cnt2 > nums.length / 3) res.add(candidate2);
        return res;
    }
}
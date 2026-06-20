class Solution {
    public int majorityElement(int[] nums) {
       /*
       I'll use the Boyer-Moore Voting Algorithm 
       First, I'll initialize two variables: one for the candidate majority element, and one for the count. 
       Then I'll iterate through the array. 
       If the current element matches the candidate, I'll increment the count. 
       Otherwise, I'll decrement the count. 
       When the count reaches zero, I'll update the candidate to the current element. 
       At the end, the candidate is the majority element.
       */
        int majority = nums[0];
        int cnt = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == majority){
                cnt++;
            }else{
                cnt--;
                if(cnt == 0){
                    majority = nums[i];
                    cnt = 1;
                }
            }
        }
        return majority;
    }
}
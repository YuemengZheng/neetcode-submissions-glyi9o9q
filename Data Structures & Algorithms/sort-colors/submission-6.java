class Solution {
    public void sortColors(int[] nums) {
        /*
        Before I start, can I clarify the constraints? What's the range of the array size? 
        And are the elements guaranteed to be 0, 1, and 2 only?

        "I use three pointers. p0 marks where the next 0 should go, p2 marks where the next 2 should go, and cur scans through the array.
        placing each element into its correct region

        steps:
        For each element at cur:
        If it's 1, it's already in the right region, so I just move cur forward.
        If it's 0, I swap it with p0, then move both p0 and cur.
        If it's 2, I swap it with p2 and move p2 left

        I stop when cur passes p2, since everything is sorted by then."

        */
        int p0 = 0;
        int cur = 0;
        int p2 = nums.length - 1;
        while(cur <= p2){
            if(nums[cur] == 1){
                cur++;
            }else if(nums[cur] == 0){
                swap(cur, p0, nums);
                cur++;
                p0++;
            }else{
                swap(cur, p2, nums);
                p2--;
            }
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
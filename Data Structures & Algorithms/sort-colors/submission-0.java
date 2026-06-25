class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;

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
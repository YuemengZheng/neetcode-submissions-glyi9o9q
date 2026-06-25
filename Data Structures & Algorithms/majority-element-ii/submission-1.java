class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 三方对抗， 最多有2个majority elements， 所以我们设置两个候选人和记录他们的cnts
        // initialize 前两个是候选人
        // loop through the arr
        // 当cur 元素属于他们其中一个 cnt++
        // 当cur 和他们都不一样，且他们其中一个是0，我们就替换candidate
        // otherwise，相互抵消
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
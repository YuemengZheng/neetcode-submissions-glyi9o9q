class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        High Level(一句话):
        "I'll use two pointers to keep unique elements at the front and skip duplicates."
        Main Steps(讲细节):
        "I use pointer i to mark where the next unique element goes, 
        and pointer j to scan through. When j finds a different element from i-1, 
        I place it at i and move both pointers. When j finishes, i is the count of unique elements."
        */
        int i = 1;
        int j = 1;
        while(j < nums.length){
            if(nums[j] != nums[i - 1]){
                nums[i++] = nums[j++];
            }else{
                j++;
            }
        }
        return i;
    }
}
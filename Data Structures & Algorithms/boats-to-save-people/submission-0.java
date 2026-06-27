class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // sort the arr
        // use two pointers starting from both ends
        // if sum <= limit cnt++， move both
        // else cnt++, move right to left
        Arrays.sort(people);
        int cnt = 0;
        int l = 0;
        int r = people.length - 1;
        while(l <= r){
            int sum = l < r ? people[l] + people[r] : people[l];
            if(sum <= limit){
                cnt++;
                l++;
                r--;
            }else{
                cnt++;
                r--;
            }
        }
        return cnt;
    }
}
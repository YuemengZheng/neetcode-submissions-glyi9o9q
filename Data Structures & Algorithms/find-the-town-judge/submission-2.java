class Solution {
    public int findJudge(int n, int[][] trust) {
        /*
        1. can we trust ourselves?
        2. can we trust more than one ppl
        3. can we assume each pair of trust is unique
    
        since the goal is to find one that can get n - 1 trust and do not trust others
        so we need to use a arr to record the trust score,
        treat trust one ppl -1, get the trust from other ppl +1 => when we find a n - 1 => judge
        */
        int[] score = new int[n + 1];
        for(int[] pair : trust) {
            score[pair[0]]--;
            score[pair[1]]++;
        }
        for(int i = 0; i <= n; i++) {
            if(score[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
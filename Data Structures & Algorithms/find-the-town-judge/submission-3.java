class Solution {
    public int findJudge(int n, int[][] trust) {
        /*
        Goal:
        "Find the town judge — the person who trusts nobody but is trusted by everyone else."

        High level:
        "Use a score array where trusting someone is -1 and being trusted is +1. 
        The judge will have a score of n-1."

        Main steps:
        "Iterate through the trust array, decrement the score of the person who trusts, 
        and increment the score of the person being trusted. Then find the person with score equal to n-1."

        TC & SC:
        "Time complexity is O(n + t) where t is the number of trust pairs. 
        Space complexity is O(n) for the score array
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
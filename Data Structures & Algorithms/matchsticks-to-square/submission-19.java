class Solution {
    public boolean makesquare(int[] matchsticks) {
        /*
        High level:
        Use backtracking where each element has four choices — which side to place it in

        Main steps:
        i will first get the total sum and the target side length
        I use a helper function with inputs: the array, current index, four sides array, and target length.
        Base case: when current index equals array length, check if all four sides are equal.
        Otherwise, try placing the current element into each of the four sides.
         Skip if it exceeds the target length, add it, recurse to the next element, then backtrack."

        TC & SC:
        "Time complexity is O(4^n) in the worst case since each element has four choices. 
        With pruning the actual performance is much better. 
        Space complexity is O(n) for the recursion stack."
        */
        int sum = 0;
        for(int num : matchsticks){
            sum += num;
        }
        if(sum % 4 != 0) return false;
        int[] sides = new int[4];
        return backtracking(matchsticks, 0, sides, sum / 4);  
    }
    private boolean backtracking(int[] matchsticks, int cur, int[] sides, int len){
        if(cur == matchsticks.length){
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        for(int i = 0; i < 4; i++){
            if(sides[i] + matchsticks[cur] > len) continue;
            sides[i] += matchsticks[cur];
            if(backtracking(matchsticks, cur + 1, sides, len)) return true;
            sides[i] -= matchsticks[cur];
        }
        return false;
    }
}

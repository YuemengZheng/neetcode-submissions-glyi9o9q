class Solution {
    public boolean makesquare(int[] matchsticks) {
        // each element have 4 choices to choose
        // for the recursion tree, each level represents a num, have 4 choice
        // we have n elements, so the tree is n levels deep
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

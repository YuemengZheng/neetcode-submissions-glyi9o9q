class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        /*
        Our goal is to check the validation of each query — 
        for each query, determine if one course is a prerequisite of another, including indirect prerequisites.

        I'll use Floyd-Warshall to precompute reachability between all pairs of courses. 
        Then answer each query in O(1) by looking up the reachability matrix.

        For the main steps: first, I'll initialize a 2D boolean array reachable, 
        where reachable[i][j] means course i is a prerequisite of course j. 
        Then I'll initialize the direct prerequisites

        Next, I'll propagate indirect reachability. 
        For each intermediate node mid, if i can reach mid and mid can reach j, then i can reach j.
        Finally, for each query, I just look up the reachable matrix.

        Time complexity is O(n³ cubed + Q) where n is the number of courses and Q is the number of queries. 
        Space complexity is O(n²) for the reachability matrix.
        */
        boolean[][] reachable = new boolean[numCourses][numCourses];
        for(int[] pair : prerequisites) {
            reachable[pair[0]][pair[1]] = true;
        }

        for(int mid = 0; mid < numCourses; mid++) {
            for(int i = 0; i < numCourses; i++) {
                for(int j = 0; j < numCourses; j++) {
                    if(reachable[i][mid] && reachable[mid][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries) {
            res.add(reachable[q[0]][q[1]]);
        }
        return res;
    }
}
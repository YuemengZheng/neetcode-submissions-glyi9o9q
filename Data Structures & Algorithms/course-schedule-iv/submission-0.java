class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
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
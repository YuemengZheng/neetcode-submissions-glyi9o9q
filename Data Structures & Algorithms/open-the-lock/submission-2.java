class Solution {
    public int openLock(String[] deadends, String target) {
        /*
        Goal:
        "Find the minimum number of turns to reach the target combination, avoiding deadends."

        High level:
        "Use BFS since we want the shortest path. Each state is a 4-digit string, 
        and each move turns one wheel one slot forward or backward."

        Main steps:
        "Start from '0000', use a visited set to avoid revisiting states and a deadends set to skip invalid states.
        At each level, for each current state, try all 8 possible moves 
        — 4 wheels times 2 directions. If the next state is not a deadend and not visited, add it to the queue.
        When we reach the target, return the current step count."

        TC & SC:
        "Time complexity is O(10^4) since there are at most 10,000 possible states and each is visited once.
        Space complexity is O(10^4) for the visited set and queue."
        */
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000")) return -1;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.poll();
                if(cur.equals(target)) {
                    return step;
                }
                for(int index = 0; index < 4; index++) {
                    String moveFront = getNext(cur, index, -1);
                    String moveAfter = getNext(cur, index, 1);
                    if(!set.contains(moveFront) && !visited.contains(moveFront)){
                        q.offer(moveFront);
                        visited.add(moveFront);
                    } 
                    if(!set.contains(moveAfter) && !visited.contains(moveAfter)){
                        q.offer(moveAfter);
                        visited.add(moveAfter);
                    }
                }
            } 
            step++;
        }
        return -1;  
    }
    private String getNext(String cur, int i, int dir) {
        char[] arr = cur.toCharArray();
        arr[i] = (char)((arr[i] - '0' + dir + 10) % 10 + '0');
        return new String(arr);
    }
}
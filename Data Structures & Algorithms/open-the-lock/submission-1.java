class Solution {
    public int openLock(String[] deadends, String target) {
        // use bfs, every time choose one position, +1 or -1
        // when we meet the deadends skip it, when we meet the target, return the steps
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
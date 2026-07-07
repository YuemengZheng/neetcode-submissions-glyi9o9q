/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
    // use dfs to recursively divide the area into four sections, until each section has the same val
        return dfs(grid, 0, 0, grid.length);
    }
    // dfs takes the grid, position, length of the area, output => node
    private Node dfs(int[][] grid, int i, int j, int len){
        if(isSame(grid, i, j, len)) return new Node(grid[i][j] == 1, true);

        Node cur = new Node(true, false);
        cur.topLeft = dfs(grid, i, j, len / 2);
        cur.topRight = dfs(grid, i, j + len / 2, len / 2);
        cur.bottomLeft = dfs(grid, i + len / 2, j, len / 2);
        cur.bottomRight = dfs(grid, i + len / 2, j + len / 2, len / 2);
        return cur;
    }
    private boolean isSame(int[][] grid, int i, int j, int len){
        int num = grid[i][j];
        for(int r = i; r < i + len; r++){
            for(int c = j; c < j + len; c++){
                if(grid[r][c] != num){
                    return false;
                }
            }
        }
        return true;
    }
}
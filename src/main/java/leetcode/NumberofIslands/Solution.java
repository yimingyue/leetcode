package leetcode.NumberofIslands;

/**
 * Created by ymyue on 1/7/16.
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1')
                    num++;
                helper(grid, i, j);
            }
        }
        return  num;
    }

    private void helper(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        if (i > 0 && grid[i-1][j] == '1') helper(grid, i-1, j);
        if (i < grid.length-1 && grid[i+1][j] == '1') helper(grid, i+1, j);
        if (j > 0 && grid[i][j-1] == '1') helper(grid, i, j-1);
        if (j < grid[i].length-1 && grid[i][j+1] == '1') helper(grid, i, j+1);
    }
}

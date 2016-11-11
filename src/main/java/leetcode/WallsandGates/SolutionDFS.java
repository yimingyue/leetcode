package leetcode.WallsandGates;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(mnk)
 * Space complexity: O(1)
 */
public class SolutionDFS {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i-1, j, 1);
                    dfs(rooms, i+1, j, 1);
                    dfs(rooms, i, j-1, 1);
                    dfs(rooms, i, j+1, 1);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int d) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] <= d)
            return;
        rooms[i][j] = d;
        dfs(rooms, i-1, j, d+1);
        dfs(rooms, i+1, j, d+1);
        dfs(rooms, i, j-1, d+1);
        dfs(rooms, i, j+1, d+1);
    }
}

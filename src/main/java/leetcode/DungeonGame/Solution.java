package leetcode.DungeonGame;

/**
 * Created by ymyue on 6/27/16.
 * Time complexity: O(MN)
 * Space complexity: O(n)
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            throw new IllegalArgumentException();
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] h = new int[n];
        for (int i = m-1; i >= 0; i --) {
            for (int j = n-1; j >= 0; j--) {
                int tmp = 0;
                if (i < m-1 && j < n-1) {
                    tmp = Math.min(h[j], h[j+1]);
                } else if (i < m-1) {
                    tmp = h[j];
                } else if (j < n-1) {
                    tmp = h[j+1];
                }
                h[j] = dungeon[i][j] < 0 ? Math.max(1, tmp) - dungeon[i][j] : Math.max(tmp-dungeon[i][j], 1);
            }
        }
        return h[0];
    }
}

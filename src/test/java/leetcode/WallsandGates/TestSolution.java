package leetcode.WallsandGates;

import org.junit.Test;

/**
 * Created by ymyue on 1/7/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        int[][] rooms = new int[][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        new Solution().wallsAndGates(rooms);
        System.out.print(rooms);
    }
}

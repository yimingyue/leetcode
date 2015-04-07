package other.ShortestDistance;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 1/14/15
 * Time: 11:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestShortestDistance {
    @Test
    public void test1() {
        /**
         * matrix:
         * 1 start
         * end 0
         */
        Solution s = new Solution();
        boolean [][] board = {{true, true}, {true, false}};
        int x1 = 0;
        int y1 = 1;
        int x2 = 1;
        int y2 = 0;
        assertEquals(s.shortestDistance(board, x1, y1, x2, y2), 2);
    }

    @Test
    public void test2() {
        /**
         * matrix:
         * 0 start
         * end 0
         */
        Solution s = new Solution();
        boolean [][] board = {{false, true}, {true, false}};
        int x1 = 0;
        int y1 = 1;
        int x2 = 1;
        int y2 = 0;
        assertEquals(s.shortestDistance(board, x1, y1, x2, y2), -1);
    }

    @Test
    public void test3() {
        /**
         * matrix:
         * 0 0 start
         * end 0 1
         * 1 1 1
         */
        Solution s = new Solution();
        boolean [][] board = {{false, false, true}, {true, false, true}, {true, true, true}};
        int x1 = 0;
        int y1 = 2;
        int x2 = 1;
        int y2 = 0;
        assertEquals(s.shortestDistance(board, x1, y1, x2, y2), 5);
    }

    @Test
    public void test4() {
        /**
         * matrix:
         * 0 0 0 s
         * 0 e 0 1
         * 1 1 0 1
         * 1 0 1 1
         * 1 1 1 1
         */
        Solution s = new Solution();
        boolean [][] board = {{false, false, false, true}, {false, true, false,true},
                {true, true, false, true}, {true, false, true, true}, {true, true, true, true}};
        int x1 = 0;
        int y1 = 3;
        int x2 = 1;
        int y2 = 1;
        assertEquals(s.shortestDistance(board, x1, y1, x2, y2), 11);
    }
}

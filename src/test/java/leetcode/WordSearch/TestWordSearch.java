package leetcode.WordSearch;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ymyue on 6/21/15.
 */
public class TestWordSearch {
    @Test
     public void test1() {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        assertTrue(new Solution().exist(board, "ABCCED"));
    }

    @Test
    public void test2() {
        char[][] board = {
                {'a'}
        };
        assertFalse(new Solution().exist(board, "ab"));
    }
}

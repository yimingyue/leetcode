package leetcode.WordSearchII;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 12/31/15.
 */
public class TestSolution {
    Solution2 solution = new Solution2();
    @Test
    public void test0() {
        char[][] board = new char[][] {{'a','a','a','a'}, {'a','a','a','a'}, {'a','a','a','a'}};
        String[] words = {"aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaab"};
        Assert.assertArrayEquals(new String[] {}, solution.findWords(board, words).toArray());
    }

    @Test
    public void test2() {
        char[][] board = new char[][] {{'a','b'}, {'a','a'}};
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        Assert.assertArrayEquals(new String[] {}, solution.findWords(board, words).toArray());
    }

    @Test
    public void test3() {
        String[] rows = new String[] {"oaan","etae","ihkr","iflv"};
        char[][] board = new char[rows.length][];
        for (int i = 0; i < rows.length; i++)
            board[i] = rows[i].toCharArray();
        String[] dict = new String[] {"oath","pea","eat","rain"};
        Assert.assertArrayEquals(new String[] {"oath", "eat"}, solution.findWords(board, dict).toArray());
    }
}

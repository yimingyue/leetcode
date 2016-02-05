package leetcode.WordSearchII;

import org.junit.Test;

import java.util.List;

/**
 * Created by ymyue on 12/31/15.
 */
public class TestSolution {
    @Test
    public void test0() {
        char[][] board = new char[][] {{'a','a','a','a'}, {'a','a','a','a'}, {'a','a','a','a'}};
        String[] words = {"aaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaaaaaab"};
        List<String> rList = new Solution().findWords(board, words);
    }

    @Test
    public void test2() {
        char[][] board = new char[][] {{'a','b'}, {'a','a'}};
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        List<String> rList = new Solution().findWords(board, words);
    }
}

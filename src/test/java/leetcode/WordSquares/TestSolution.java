package leetcode.WordSquares;

import org.junit.Test;

/**
 * Created by ymyue on 10/18/16.
 */
public class TestSolution {
//    MedianFinder solution = new MedianFinder();
    SolutionTrie solution = new SolutionTrie();

    @Test
    public void test0() {
        solution.wordSquares(new String[]{"area", "lead", "wall", "lady", "ball"});
    }

    @Test
    public void test1() {
        solution.wordSquares(new String[]{"abat","baba","atan","atal"});
    }
}

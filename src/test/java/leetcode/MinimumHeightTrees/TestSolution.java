package leetcode.MinimumHeightTrees;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/23/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertEquals(new LinkedList<Integer>(Arrays.asList(0, 1)), new Solution().findMinHeightTrees(2, new int[][]{{0, 1}}));
    }

    @Test
    public void test1() {
        assertEquals(new LinkedList<Integer>(Arrays.asList(3, 4)), new Solution().findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
    }
}

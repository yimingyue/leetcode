package leetcode.TheSkylineProblem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/25/16.
 */
public class TestSolution {
    @Test
    public void test0 () {
        int[][] buildings = new int[][] {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] r = new int[][] {{2, 10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0}};
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] a : r)
            list.add(a);
        assertEquals(list, new Solution().getSkyline(buildings));
    }

    @Test
    public void test1 () {
        int[][] buildings = new int[][] {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] r = new int[][] {{2, 10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0}};
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] a : r)
            list.add(a);
        assertEquals(list, new Solution2().getSkyline(buildings));
    }

    @Test
    public void test2 () {
        int[][] buildings = new int[][] {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int[][] r = new int[][] {{2, 10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0}};
        Assert.assertArrayEquals(r, new Solution3().getSkyline(buildings).toArray());
    }

    @Test
    public void test3 () {
        int[][] buildings = new int[][] {{0, 2, 3}, {2, 5, 3}};
        int[][] r = new int[][] {{0, 3}, {5, 0}};
        Assert.assertArrayEquals(r, new Solution3().getSkyline(buildings).toArray());
    }
}

package leetcode.NumberofIslandsII;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/8/16.
 */
public class TestSolution {
    Solution4 solution = new Solution4();
    @Test
    public void test0() {
        int[][] positions = new int[][]{
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1},
                {1, 1}
        };
        int[] result = new int[]{1, 1, 2, 3, 1};
        List<Integer> list = new ArrayList<Integer>();
        for (int num : result)
            list.add(num);
        assertEquals(list, solution.numIslands2(3, 3, positions));
    }

    @Test
    public void test1() {
        int[][] positions = new int[][] {
                {0, 1},
                {1, 2},
                {2, 1},
                {1, 0},
                {0, 2},
                {0, 0},
                {1, 1}
        };
        int[] result = new int[] {1,2,3,4,3,2,1};
        List<Integer> list = new ArrayList<Integer>();
        for (int num : result)
            list.add(num);
        assertEquals(list, solution.numIslands2(3, 3, positions));
    }

    @Test
    public void test2() {
        int[][] positions = new int[][]{
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1}
        };
        int[] result = new int[]{1, 1, 2, 3};
        List<Integer> list = new ArrayList<Integer>();
        for (int num : result)
            list.add(num);
        assertEquals(list, solution.numIslands2(3, 3, positions));
    }

    @Test
    public void test3() {
        int[][] positions = new int[][]{
                {2, 2},
                {2, 1},
                {1, 3},
                {0, 4}
        };
        int[] result = new int[]{1, 1, 2, 3};
        List<Integer> list = new ArrayList<Integer>();
        for (int num : result)
            list.add(num);
        assertEquals(list, solution.numIslands2(3, 6, positions));
    }

    @Test
    public void test4() {
        int[][] positions = new int[][]{
                {0, 1},
                {0, 0}
        };
        int[] result = new int[]{1, 1};
        List<Integer> list = new ArrayList<Integer>();
        for (int num : result)
            list.add(num);
        assertEquals(list, solution.numIslands2(1, 2, positions));
    }
}

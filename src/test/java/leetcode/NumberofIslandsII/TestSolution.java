package leetcode.NumberofIslandsII;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/8/16.
 */
public class TestSolution {
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
        assertEquals(list, new Solution().numIslands2(3, 3, positions));
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
        assertEquals(list, new Solution().numIslands2(3, 3, positions));
    }
}

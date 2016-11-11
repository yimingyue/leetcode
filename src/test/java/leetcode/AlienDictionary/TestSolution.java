package leetcode.AlienDictionary;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 2/9/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();
    @Test
    public void test0() {
        String[] words = new String[] {"wrt", "wrf", "er", "ett", "rftt"};
        assertEquals("wertf", solution.alienOrder(words));
    }

    @Test
    public void test1() {
        String[] words = new String[] {"wnlb"};
        assertEquals("wnlb", solution.alienOrder(words));
    }

    @Test
    public void test2() {
        String[] words = new String[] {"zy", "zx"};
        assertEquals("yxz", solution.alienOrder(words));
    }

    @Test
    public void test3() {
        String[] words = new String[] {"wrtkj","wrt"};
        Assert.assertEquals("", solution.alienOrder(words));
    }
}

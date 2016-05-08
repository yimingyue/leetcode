package leetcode.AlienDictionary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 2/9/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        String[] words = new String[] {"wrt", "wrf", "er", "ett", "rftt"};
        assertEquals("wertf", new Solution().alienOrder(words));
    }

    @Test
    public void test1() {
        String[] words = new String[] {"wnlb"};
        assertEquals("wnlb", new Solution().alienOrder(words));
    }
}

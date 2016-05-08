package leetcode.RemoveInvalidParentheses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 2/14/16.
 */
public class TestSolutionDFS {
    @Test
    public void test0() {
        List<String> list = new ArrayList<>();
        list.add("");
        assertEquals(list, new SolutionDFS().removeInvalidParentheses(")("));
    }

    @Test
    public void test1() {
        System.out.println(-5 >> 2);
        System.out.println(-5 >> 3);
    }
}

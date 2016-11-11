package leetcode.ExpressionAddOperators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 1/14/16.
 */
public class TestSolution {
    SolutionBackTracking solution = new SolutionBackTracking();
    @Test
     public void test0() {
        List<String> list = new ArrayList<>();
        list.add("1*2*3");
        list.add("1+2+3");
        assertEquals(list, solution.addOperators("123", 6));
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("2*3+2");
        list.add("2+3*2");
        assertEquals(list, new Solution().addOperators("232", 8));
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("1*0+5");
        list.add("10-5");
        assertEquals(list, new Solution().addOperators("105", 5));
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("0*0");
        list.add("0-0");
        list.add("0+0");
        assertEquals(list, new Solution().addOperators("00", 0));
    }

    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        assertEquals(list, new Solution().addOperators("3456237490", 9191));
    }

    @Test
    public void test5() {
        List<String> list = new ArrayList<>();
        assertEquals(list, solution.addOperators("2147483648", -2147483648));
    }
}

package leetcode.RearrangeStringkDistanceApart;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 6/14/16.
 */
public class TestSolution {
    //    SolutionDeque solution = new SolutionDeque();
//    SolutionPQ solution = new SolutionPQ();
//    SolutionPQLambda solution = new SolutionPQLambda();
    Solution3 solution = new Solution3();

    @Test
    public void test0() {
        Assert.assertEquals("", solution.rearrangeString("aaabbbcccd", 4));
    }

    @Test
    public void test1() {
        Assert.assertEquals("abcabc", solution.rearrangeString("aabbcc", 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals("", solution.rearrangeString("aabbcc", 4));
    }

    @Test
    public void test3() {
        Assert.assertEquals("abcdefabcdef", solution.rearrangeString("aabbccddeeff", 6));
    }

    @Test
    public void test4() {
        Assert.assertEquals("bab", solution.rearrangeString("abb", 2));
    }

    @Test
    public void test5() {
        Assert.assertEquals("abaca", solution.rearrangeString("aaabc", 2));
    }

    @Test
    public void test6() {
        Assert.assertEquals("abb", solution.rearrangeString("bab", 0));
    }
}

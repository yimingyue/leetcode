package leetcode.VerifyPreorderSerializationofaBinaryTree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 7/27/16.
 */
public class TestSolution {
    SolutionRecursive solution = new SolutionRecursive();

    @Test
    public void test0() {
        Assert.assertTrue(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")) ;
    }

    @Test
    public void test1() {
        Assert.assertFalse(solution.isValidSerialization("1,#"));
    }

    @Test
    public void test2() {
        Assert.assertFalse(solution.isValidSerialization("9,#,#,1"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(solution.isValidSerialization("#"));
    }
}

package leetcode.LongestRepeatingCharacterReplacement;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ymyue on 10/18/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        Assert.assertEquals(4, solution.characterReplacement("ABAB", 2));
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, solution.characterReplacement("AABABBA", 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, solution.characterReplacement("ABAB", 0));
    }

    @Test
    public void test3() {
        Assert.assertEquals(7, solution.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }

    @Test
    public void test4() {
        Assert.assertEquals(3, solution.characterReplacement("BAAA", 0));
    }
}

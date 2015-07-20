package leetcode.LengthofLastWord;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 6/20/15.
 */
public class TestSolution {
    @Test
    public void test() {
        String s = "qWnqNICa   ADGZNrBw  DdxMEuhNuvTJaETF   KhKKfVFX";
        assertEquals(8, new Solution().lengthOfLastWord(s));
    }
}

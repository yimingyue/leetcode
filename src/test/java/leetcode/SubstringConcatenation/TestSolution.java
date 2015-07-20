package leetcode.SubstringConcatenation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymyue on 5/25/15.
 */
public class TestSolution {
    @Test
    public void test1() {
        List list = Arrays.asList(0, 9);
        assertEquals(list, new Solution2().findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
    }

    @Test
    public void test2() {
        int a = 0;
        assertEquals('0', (char)a);
    }
}

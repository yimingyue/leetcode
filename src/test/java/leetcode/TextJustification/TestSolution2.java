package leetcode.TextJustification;

import org.junit.Test;

import java.util.List;

/**
 * Created by ymyue on 12/27/15.
 */
public class TestSolution2 {
    @Test
    public void test0() {
        String[] arr = new String[] {"a","b","c","d","e"};
        List<String> rList = new Solution2().fullJustify(arr, 3);
    }

    @Test
    public void test1() {
        String[] arr = new String[] {"What","must","be","shall","be."};
        List<String> rList = new Solution2().fullJustify(arr, 12);
    }

    @Test
    public void test3() {
        String[] arr = new String[] {""};
        List<String> rList = new Solution2().fullJustify(arr, 2);
    }

    @Test
    public void test4() {
        String[] arr = new String[] {""};
        List<String> rList = new Solution2().fullJustify(arr, 0);
    }
}

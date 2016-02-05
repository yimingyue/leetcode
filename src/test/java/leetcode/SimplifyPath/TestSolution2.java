package leetcode.SimplifyPath;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 12/29/15.
 */
public class TestSolution2 {
    @Test
    public void test1() {
        assertEquals("/...", new Solution2().simplifyPath("/..."));
    }

    @Test
    public void test2() {
        assertEquals("/...", new Solution2().simplifyPath("/.../"));
    }

    @Test
    public void test3() {
        assertEquals("/", new Solution2().simplifyPath("///eHx/.."));
    }

    @Test
    public void test4() {
        assertEquals("/wFmgf/e/SF/g/MJY", new Solution2().simplifyPath("///./wFmgf/R/fHhJ/./.././.././e///SF/.///JaO/../g/MJY/S/.."));
    }

    @Test
    public void test5() {
        assertEquals("/", new Solution2().simplifyPath("/../"));
    }
}

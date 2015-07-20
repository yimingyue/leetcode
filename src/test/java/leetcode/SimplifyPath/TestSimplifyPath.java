package leetcode.SimplifyPath;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by ymyue on 6/21/15.
 */
public class TestSimplifyPath {
    @Test
    public void test1() {
        assertEquals("/...", new Solution().simplifyPath("/..."));
    }

    @Test
    public void test2() {
        assertEquals("/...", new Solution().simplifyPath("/.../"));
    }

    @Test
    public void test3() {
        assertEquals("/", new Solution().simplifyPath("///eHx/.."));
    }

    @Test
    public void test4() {

        assertEquals("/wFmgf/e/SF/g/MJY", new Solution().simplifyPath("///./wFmgf/R/fHhJ/./.././.././e///SF/.///JaO/../g/MJY/S/.."));
    }
}

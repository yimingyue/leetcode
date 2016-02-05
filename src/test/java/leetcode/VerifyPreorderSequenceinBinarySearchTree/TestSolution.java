package leetcode.VerifyPreorderSequenceinBinarySearchTree;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

/**
 * Created by ymyue on 1/30/16.
 */
public class TestSolution {
    @Test
    public void test0() {
        assertFalse(new Solution().verifyPreorder(new int[] {1, 3, 4, 2}));
    }
}

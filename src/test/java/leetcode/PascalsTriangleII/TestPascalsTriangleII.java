package leetcode.PascalsTriangleII;

import org.junit.Test;

import java.util.List;

/**
 * Created by ymyue on 10/10/15.
 */
public class TestPascalsTriangleII {
    @Test
    public void test0() {
        Solution solution = new Solution();
        for (int i = 0; i < 5; i++) {
            List<Integer> list = solution.getRow(i);
            System.out.println(list.toString());
        }
    }
}

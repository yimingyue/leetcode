package leetcode.PalindromePartitioning;

import org.junit.Test;

import java.util.List;

/**
 * Created by ymyue on 10/18/15.
 */
public class TestSolution {
    @Test
    public void test0 () {
        Solution s = new Solution();
        List<List<String>> rList = s.partition("bb");
        for (List<String> list : rList)
            System.out.println(list.toString());
    }
}

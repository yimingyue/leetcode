package leetcode.WordBreakII;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ymyue on 10/18/15.
 */
public class TestSolution2 {
    @Test
    public void test() {
        Solution2 solution2 = new Solution2();
        Set<String> set = new HashSet<>();
        set.add("a");
        List<String> rList = solution2.wordBreak("a", set);
    }
}

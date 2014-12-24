package WordLadderII;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/6/14
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestWordLadderII {
    @Test
    public void Test1() {
        Solution2 solution2 = new Solution2();
        String start = "a";
        String end = "c";
        String[] dicts = {"a", "b", "c"};
        Set<String> set = new HashSet<>();
        for (String str : dicts) {
            set.add(str);
        }
        List<List<String>> list = solution2.findLadders(start, end, set);
    }
}

package leetcode.WordLadder;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/6/14
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestWordLadder {
    @Test
    public void Test1() {
        Solution2 solution = new Solution2();
        String start = "hot";
        String end = "dog";
        String[] dicts = {"hot","dog","dot"};
        Set<String> dict = new HashSet<>();
        for (String str : dicts)
            dict.add(str);
        assertEquals(3, solution.ladderLength(start, end, dict));
    }
}

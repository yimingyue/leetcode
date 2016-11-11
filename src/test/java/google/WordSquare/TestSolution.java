package google.WordSquare;

import org.junit.Test;

import java.util.List;

/**
 * Created by ymyue on 10/10/16.
 */
public class TestSolution {
    Solution solution = new Solution();

    @Test
    public void test0() {
        List<List<String>> result = solution.wordSquare(new String[]{"ABCD", "BNRT", "CRM", "DT", "DOG", "CAT"}, 4);
    }
}

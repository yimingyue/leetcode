package leetcode.PalindromePairs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/11/16.
 */
public class TestSolution {
    Solution2 solution = new Solution2();
    @Test
    public void test0() {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> result = new ArrayList<>();
        int[][] arr = new int[][] {
                {0, 1},
                {1, 0},
                {3, 2},
                {3, 3},
                {2, 4}
        };
        for (int[] row : arr) {
            ArrayList<Integer> tmp = new ArrayList<>(2);
            tmp.add(row[0]);
            tmp.add(row[1]);
            result.add(tmp);
        }
        Assert.assertEquals(result, solution.palindromePairs(words));
    }

    @Test
    public void test1() {
        String[] words = {"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"};
        solution.palindromePairs(words);
    }

    @Test
    public void test2() {
        solution.palindromePairs(new String[] {"a","b","c","ab","ac","aa"});
    }
}

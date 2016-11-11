package leetcode.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/22/16.
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<> ();
        for (int i = 0; i < numRows; i++) {
            for (int j = list.size()-1; j > 0; j--)
                list.set(j, list.get(j) + list.get(j-1));
            list.add(1);
            res.add(new ArrayList<> (list));
        }
        return res;
    }
}

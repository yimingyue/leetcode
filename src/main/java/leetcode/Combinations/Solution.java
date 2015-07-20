package leetcode.Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rList = new ArrayList<>();
        if (k > n || n <= 0 || k <= 0)
            return rList;
        List<Integer> list = new ArrayList<> ();
        build(rList, list, n, k, 1);
        return rList;
    }

    private void build(List<List<Integer>> rList, List<Integer> list, int n, int k, int v) {
        if (list.size() + n - v + 1 < k)
            return;
        if (v > n)
            return;
        for (int i = v; i <= n; i++) {
            List<Integer> nList = new ArrayList(list);
            nList.add(i);
            if (nList.size() == k)
                rList.add(nList);
            else
                build(rList, nList, n, k, i+1);
        }
    }
}

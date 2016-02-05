package leetcode.FactorCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 1/29/16.
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rList = new ArrayList<>();
        if (n == 1)
            return rList;
        helper(rList, new ArrayList<Integer>(), n, factors(n), 0);
        return rList;
    }

    private void helper(List<List<Integer>> rList, List<Integer> list, int n, List<Integer> factors, int s) {
        for (int i = s; i < factors.size(); i++) {
            int v = factors.get(i);
            if (n/v < v)
                break;
            if (n % v == 0) {
                list.add(v);
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(n/v);
                rList.add(tmp);
                helper(rList, list, n / v, factors, i);
                list.remove(list.size()-1);
            }
        }
    }

    private List<Integer> factors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0)
                list.add(i);
        }
        return list;
    }
}

package leetcode.CombinationSumIII;

import java.util.*;

/**
 * Created by ymyue on 11/2/15.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Map<Integer, List<List<Integer>>> map = new HashMap<> ();
        List<Integer> list = new ArrayList<> ();
        List<List<Integer>> lList = new ArrayList<> ();
        lList.add(list);
        map.put(0, lList);
        for (int i = 1; i <= 9; i++) {
            Map<Integer, List<List<Integer>>> nMap = new HashMap<>();
            for (int key : map.keySet()) {
                int nKey = key + i;
                if (nKey > n)
                    continue;
                List<List<Integer>> mList = map.get(key);
                for (List<Integer> iList : mList) {
                    if ((k - iList.size() - 1) * 9 + i < n - key)
                        continue;
                    List<Integer> nList = new ArrayList<> (iList);
                    nList.add(i);
                    List<List<Integer>> rList = null;
                    if (!nMap.containsKey(nKey)) {
                        rList = new ArrayList<> ();
                        nMap.put(nKey, rList);
                    } else {
                        rList = nMap.get(nKey);
                    }
                    rList.add(nList);
                }
            }
            for (int key : nMap.keySet()) {
                if (map.containsKey(key))
                    map.get(key).addAll(nMap.get(key));
                else
                    map.put(key, nMap.get(key));
            }
        }
        if (n == 0 || !map.containsKey(n))
            return new ArrayList<List<Integer>> ();
        List<List<Integer>> kList = new ArrayList<> ();
        for (List<Integer> iList : map.get(n)) {
            if (iList.size() == k)
                kList.add(iList);
        }
        return kList;
    }
}

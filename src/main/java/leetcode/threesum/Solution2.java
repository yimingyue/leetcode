package leetcode.threesum;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] num) {
        Set<List<Integer>> set = new HashSet<> ();
        List<Integer> list = new ArrayList<> ();
        List<List<Integer>> rList = new ArrayList<> ();
        if (num.length < 3)
            return rList;
        for (int n : num)
            list.add(n);
        Collections.sort(list);
        for (int i = 0; i < list.size()-2; i++) {
            int j = i+1;
            int k = list.size()-1;
            while (j < k) {
                int sum = list.get(i) + list.get(j) + list.get(k);
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    List<Integer> nList = new ArrayList<> ();
                    nList.add(list.get(i));
                    nList.add(list.get(j));
                    nList.add(list.get(k));
                    set.add(nList);
                    j++;
                }
            }
        }
        rList = new ArrayList<List<Integer>> (set);
        return rList;
    }
}
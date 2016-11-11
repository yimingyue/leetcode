package leetcode.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/21/14
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> rList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (num.length == 0) {
            rList.add(list);
            return rList;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        return getPermute(list);
    }

    private ArrayList<ArrayList<Integer>> getPermute(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> rList = new ArrayList<ArrayList<Integer>>();
        if (list.size() == 0) {
            rList.add(list);
            return rList;
        } else {
            ArrayList<Integer> sList = new ArrayList<Integer>();
            int j = list.size()-1;
            int v = list.get(j);
            list.remove(j);
            Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();

            ArrayList<ArrayList<Integer>> mList = getPermute(list);
            for (ArrayList<Integer> tList : mList) {
                for (int i = 0; i <= tList.size(); i++) {
                    ArrayList<Integer> nList = new ArrayList<Integer> (tList);
                    nList.add(i, v);
                    if (set.contains(nList))
                        continue;
                    else {
                        set.add(nList);
                        rList.add(nList);
                    }
                }
            }
            return rList;
        }
    }
}

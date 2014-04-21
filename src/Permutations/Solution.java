package Permutations;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/21/14
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
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
            sList.add(list.get(j));
            list.remove(j);
            while (--j >= 0 && list.get(j) == sList.get(0)) {
                sList.add(list.get(j));
                list.remove(j);
            }
            if (j < 0) {
                rList.add(sList);
                return rList;
            }

            ArrayList<ArrayList<Integer>> mList = getPermute(list);
            for (ArrayList<Integer> tList : mList) {
                for (int i = 0; i <= tList.size(); i++) {
                    list = new ArrayList<Integer>(tList);
                    list.addAll(i, sList);
                    rList.add(list);
                }

                for (int i = 1; i < sList.size(); i++) {
                    list = new ArrayList<Integer>(sList);
                    list.addAll(i, tList);
                    rList.add(list);
                }
            }
            return rList;
        }
    }

    private ArrayList<ArrayList<Integer>> merge (ArrayList<Integer> sList, ArrayList<Integer> tList) {
        for (int i = 0; i < sList.size(); i++) {
            ArrayList<Integer>
            for (int j = 0; j < )
        }
    }
}

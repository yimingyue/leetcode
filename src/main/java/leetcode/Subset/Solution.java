package leetcode.Subset;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 3/11/14
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int tmp = num[i];
            int j = i-1;
            for (; j >= 0; j--) {
                if (num[j] > tmp)
                    num[j+1] = num[j];
                else
                    break;
            }
            num[j+1] = tmp;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> iList = new ArrayList<Integer> ();
        list.add(iList);
        for (int i = 0; i < num.length; i++) {
            getSubset(list, num, i);
        }
        return list;
    }

    private void getSubset(ArrayList<ArrayList<Integer>> list, int [] num, int i) {
        int j = i-1;
        while (j >= 0 && num[j] == num[j+1])
            j--;

        if (i == j+1) {
            ArrayList<ArrayList<Integer>> tmpList = new ArrayList<ArrayList<Integer>> ();
            for (ArrayList<Integer> iList : list) {
                ArrayList<Integer> nList = new ArrayList<Integer> (iList);
                nList.add(num[i]);
                tmpList.add(nList);
            }
            list.addAll(tmpList);
        } else {
            for (int k = 0 ; k <= j+1; k++) {
                ArrayList<Integer> nList = new ArrayList<Integer> ();
                for (int l = k; l <= i; l++) {
                    nList.add(num[l]);
                }
                list.add(nList);
            }
        }
    }
}

package CombinationSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/7/14
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        quickSort(candidates, 0, candidates.length - 1);
        Map<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i <= target; i++) {
//            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> nList = new ArrayList<ArrayList<Integer>>();
//            nList.add(list);
            map.put(i, nList);
        }
        map.get(0).add(new ArrayList<Integer>());

        int i = 0;
        while (i < candidates.length) {
            int c = candidates[i];
            int t = 1;
            int s = t * c;
            while (s <= target) {
                for (int k : map.keySet()) {
                    if (k + s > target)
                        continue;
                    ArrayList<ArrayList<Integer>> iList = map.get(k);
                    ArrayList<ArrayList<Integer>> sList = map.get(s+k);
                    for (ArrayList<Integer> tList : iList) {
                        ArrayList<Integer> mList = new ArrayList<Integer>(tList);
                        for (int p = 0; p < t; p++)
                            mList.add(c);
                        sList.add(mList);
                    }
                }
                t++;
                s = t * c;
            }
            i++;
        }
        if (map.containsKey(target))
            return map.get(target);
        else
            return new ArrayList<ArrayList<Integer>>();
    }

    private void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int q = partition(a, start, end);
            quickSort(a, start, q - 1);
            quickSort(a, q + 1, end);
        }
    }

    private int partition(int[] a, int start, int end) {
        int x = a[end];
        int j = start;
        int i = start - 1;
        while (j < end) {
            if (a[j] < x) {
                i++;
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
            j++;
        }
        a[end] = a[i + 1];
        a[i + 1] = x;
        return i + 1;
    }
}
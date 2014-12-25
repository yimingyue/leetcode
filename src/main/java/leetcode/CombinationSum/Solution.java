package main.java.leetcode.CombinationSum;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/7/14
 * Time: 9:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int c : candidates) {
            list.add(c);
            sum += c;
        }
        Map<Integer, Set<ArrayList<Integer>>> rMap = new HashMap<>();
        ArrayList<Integer> emptyList = new ArrayList<>();
        Set<ArrayList<Integer>> emptySet = new HashSet<>();
        emptySet.add(emptyList);
        rMap.put(0, emptySet);
        getPermute(rMap, list, target, sum);
        ArrayList<ArrayList<Integer>> rList = new ArrayList<>();
        if (rMap.containsKey(target)) {
            Set<ArrayList<Integer>> set = rMap.get(target);
            for (ArrayList<Integer> iList : set) {
                rList.add(iList);
            }
        }
        return rList;
    }

    private void getPermute(Map<Integer, Set<ArrayList<Integer>>> rMap,
                                                                   ArrayList<Integer> list, int target, int sum) {
        if (list.isEmpty()) {
            return;
        }
        else {
            ArrayList<Integer> nList = new ArrayList<>(list);
            int v = nList.get(nList.size()-1);

            nList.remove(nList.size()-1);
            sum -= v;
            getPermute(rMap, nList, target, sum);

            if (v > target)
                return;
            else {
                Map<Integer, Set<ArrayList<Integer>>> nMap = new HashMap<>();
                for (int k : rMap.keySet()) {
                    int a = v;
                    ArrayList<Integer> aList = new ArrayList<>();
                    aList.add(v);
                    while (k + a <= target) {
                        Set<ArrayList<Integer>> set = rMap.get(k);
                        for (ArrayList<Integer> iList : set) {
                            ArrayList<Integer> tList = new ArrayList<>(iList);
                            tList.addAll(aList);
                            if (rMap.containsKey(k+a))
                                rMap.get(k+a).add(tList);
                            else if (nMap.containsKey(k+a))
                                nMap.get(k+a).add(tList);
                            else {
                                Set<ArrayList<Integer>> nSet = new HashSet<>();
                                nSet.add(tList);
                                nMap.put(k+a, nSet);
                            }
                        }
                        a += v;
                        aList.add(v);
                    }
                }
                rMap.putAll(nMap);
            }
        }
    }
}
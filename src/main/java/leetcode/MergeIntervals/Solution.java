package leetcode.MergeIntervals;

import java.util.*;

/**
 * Created by ymyue on 4/19/14.
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> list = sort(intervals);
        for (int i = 0; i < list.size() - 1; i++) {
            Interval s1 = list.get(i);
            Interval s2 = list.get(i+1);
            if (s1 .end < s2.start)
                continue;
            if (s1.end < s2.end) {
                s1.end = s2.end;
                list.remove(i);
                i--;
                continue;
            }
            list.remove(i);
            i--;
        }
        return list;
    }

    private ArrayList<Interval> sort(List<Interval> list) {
        if (list.isEmpty())
            return new ArrayList<>();
        if (list.size() == 1)
            return new ArrayList<>(list);
        int m = list.size()/2;
        ArrayList<Interval> l1 = sort(list.subList(0, m));
        ArrayList<Interval> l2 = sort(list.subList(m, list.size()));
        return merge(l1, l2);
    }

    private ArrayList<Interval> merge(ArrayList<Interval> l1, ArrayList<Interval> l2) {
        ArrayList<Interval> ilist = new ArrayList<Interval> ();
        int m = l1.size();
        int n = l2.size();
        ilist.ensureCapacity(m + n);
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            if (i == m)
                ilist.add(l2.get(j++));
            else if (j == n)
                ilist.add(l1.get(i++));
            else {
                Interval s1 = l1.get(i);
                Interval s2 = l2.get(j);
                if (s1.start < s2.start) {
                    ilist.add(s1);
                    i++;
                } else if (s1.start == s2.start) {
                    if (s1.end <= s2.end) {
                        ilist.add(s1);
                        i++;
                    } else {
                        ilist.add(s2);
                        j++;
                    }
                } else {
                    ilist.add(s2);
                    j++;
                }
            }
        }
        return ilist;
    }
}

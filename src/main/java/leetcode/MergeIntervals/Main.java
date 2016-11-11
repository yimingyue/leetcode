package leetcode.MergeIntervals;

import java.util.ArrayList;

/**
 * Created by ymyue on 4/19/14.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        ArrayList<Interval> list = new ArrayList<>();
//        list.add(new Interval(2, 3));
//        list.add(new Interval(5, 5));
//        list.add(new Interval(2,2));
        list.add(new Interval(1, 4));
        list.add(new Interval(2, 5));
        ArrayList<Interval> rList = s.merge(list);
        for (Interval inter : rList) {
            System.out.print(inter.start);
            System.out.print("\t");
            System.out.println(inter.end);
        }
    }
}

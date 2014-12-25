package leetcode.InsertIntervals;

import java.util.ArrayList;

/**
 * Created by ymyue on 4/19/14.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
//        list.add(new Interval(6, 7));
//        list.add(new Interval(9, 16));
//        list.add(new Interval(18,23));
//        list.add(new Interval(27, 32));
        ArrayList<Interval> rList = s.insert(list, new Interval(2, 3));
        for (Interval inter : rList) {
            System.out.print(inter.start);
            System.out.print("\t");
            System.out.println(inter.end);
        }
    }
}

package interview.amazon.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ymyue on 1/11/16.
 */
public class Solution {
    static class Interval {
        int start;
        int end;
        long value;
        public Interval (int a, int b, long k) {
            start = a;
            end = b;
            value = k;
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = 0;
        int b = 0;
        long k = 0;
        List<Interval> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            k = sc.nextLong();

            Interval newInterval = new Interval(a, b, k);
            for (int j = 0; j < list.size(); j++) {
                Interval interval = list.get(j);
                if (interval.end < newInterval.start) {
                    continue;
                } else {
                    if (interval.start < newInterval.start) {
                        int end = interval.end;
                        long value = interval.value;
                        interval.end = newInterval.start-1;
                        if (interval.end < newInterval.end) {
                            Interval inter = new Interval(newInterval.start, interval.end, interval.value + newInterval.value);
                            list.add(j+1, inter);
                            j++;
                        } else {

                        }
                    }
                }
            }
        }
        System.out.print(max);
    }
}

package Pow;

import java.util.ArrayList;

/**
 * Created by ymyue on 4/20/14.
 */
public class Solution {
    public double pow(double x, int n) {
        if (n == 0)
            return 1;

        ArrayList<Double> list = new ArrayList<Double> ();
        int i = 1;
        double d = x;
        if (n > 0) {
            while (i <= n) {
                list.add(d);
                d = d * d;
                if (i > Integer.MAX_VALUE/2)
                    break;
                i = i*2;
            }

            double v = 1;
            int k = list.size();
            if (i > n)
                i = i / 2;
            while (n > 0) {
                k--;
                if (n >= i) {
                    n = n-i;
                    v = v * list.get(k);
                }
                i = i/2;
            }
            return v;
        } else {
            i = -1;

            while (i >= n) {
                list.add(d);
                d = d * d;
                if (i < Integer.MIN_VALUE/2)
                    break;
                i = i*2;
            }

            double v = 1;
            int k = list.size();
            if (i < n)
                i = i/2;
            while (n < 0) {
                k--;
                if (n <= i) {
                    n = n-i;
                    v = v*list.get(k);
                }
                i = i/2;
            }
            return 1/v;
        }
    }
}
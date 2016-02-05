package leetcode.Pow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 12/18/15.
 */
public class Solution2 {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0d;
        boolean negative = false;
        long l = 0;
        if (n < 0) {
            l = (long)n * -1;
            negative = true;
        } else
            l = n;
        List<Double> list = new ArrayList<>();
        list.add(x);
        long i = 1;
        while (i < l) {
            i *= 2;
            list.add(list.get(list.size()-1) * list.get(list.size()-1));
        }
        double result = 1;
        int j = list.size()-1;
        while (l != 0) {
            if (l >= i) {
                result *= list.get(j);
                l -= i;
            }
            i /= 2;
            j--;
        }
        if (negative)
            return 1 / result;
        return result;
    }
}

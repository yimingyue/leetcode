package leetcode.DivideTwoInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 5/24/15.
 */
public class Solution2 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<> ();

        if (divisor > 0)
            list.add(0-divisor);
        else
            list.add(divisor);
        list2.add(1);

        int val = list.get(list.size()-1);
        int val2 = 1;
        while (Integer.MIN_VALUE - val <= val) {
            val = val + val;
            list.add(val);
            val2 = val2 + val2;
            list2.add(val2);
        }
        int sum = 0;
        if (dividend < 0) {
            for (int i = list.size()-1; i >= 0; i--) {
                if (dividend <= list.get(i)) {
                    sum += list2.get(i);
                    dividend -= list.get(i);
                }
            }
            if (divisor < 0)
                return sum;
            else
                return 0 - sum;
        } else {
            for (int i = list.size()-1; i>= 0; i--) {
                if (0 - dividend <= list.get(i)) {
                    sum += list2.get(i);
                    dividend += list.get(i);
                }
            }
            if (divisor < 0)
                return 0 - sum;
            else
                return sum;
        }
    }
}

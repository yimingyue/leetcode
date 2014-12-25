package leetcode.CountAndSay;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/7/14
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        int i = 1;
        int val = 1;
        while (i < n) {
            val = next(val);
            i++;
        }
        return Integer.toString(val);
    }

    private int next(int val) {
        int lastd = 1;
        int c = 0;
        int r = 0;
        ArrayList<Integer> list = new ArrayList<Integer> ();

        while (val > 0) {
            list.add(val%10);
            val /= 10;
        }
        for (int i = list.size()-1; i >= 0; i--) {
            int d = list.get(i);
            if (i == list.size()-1) {
                lastd = d;
                c = 1;
            }
            else if (d == lastd) {
                c++;
            } else {
                r = r*100;
                r += c*10;
                r += lastd;
                lastd = d;
                c = 1;
            }
        }
        r = r*100;
        r += c*10;
        r += lastd;
        return r;
    }
}

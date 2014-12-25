package leetcode.DivideTwoInteger;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/6/14
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        long divid = dividend;
        divid = Math.abs(divid);
        long divis = divisor;
        divis = Math.abs(divis);

        long [] a = new long [32];
        int [] vals = new int [32];
        int i = 0;

        int max = (Integer.MAX_VALUE) >> 1;
        while (divis <= divid) {
            a[i++] = divis;
            if (divis > max+1)
                break;
            else
                divis = divis << 1;
        }
        if (i == 0)
            return 0;
        int j = i-1;
        int val = 1;
        for (int k = 0; k < i; k++) {
            vals[k] = val;
            val = val << 1;
        }

        int r = 0;
        while (j >= 0) {
            if (divid >= a[j]) {
                divid -= a[j];
                r += vals[j];
            }
            j--;
        }
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            return -r;
        return r;
    }
}

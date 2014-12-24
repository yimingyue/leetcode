package FractiontoRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        assert(denominator != 0);
        if (numerator == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        // keypoint - convert int to long to avoid integer overflow issues
        long n = (long)numerator;
        long d = (long)denominator;
        if (n < 0 && d > 0) {
            sb.append('-');
            n = 0 - n;
        } else if (n > 0 && d < 0) {
            sb.append('-');
            d = 0 -d;
        } else if (n < 0 && d < 0) {
            n = 0 - n;
            d = 0 - d;
        }
        if (n < d)
            sb.append(0);
        else {
            long m = n / d;
            StringBuilder sb2 = new StringBuilder();
            while (m != 0) {
                sb2.append(m % 10);
                m = m / 10;
            }
            sb.append(sb2.reverse());
            n = n % d;
            if (n == 0)
                return sb.toString();
        }
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        map.put(n, 0);
        int offset = 0;
        StringBuilder sb3 = new StringBuilder();
        while (n != 0) {
            n = n * 10;
            sb3.append(n / d);
            n = n % d;
            if (map.containsKey(n)) {
                offset = map.get(n);
                // keypoint - find the beginning of the loop part
                sb.append(sb3.substring(0, offset));
                sb.append('(');
                sb.append(sb3.substring(offset));
                sb.append(')');
                return sb.toString();
            } else
                map.put(n, ++offset);
        }
        sb.append(sb3);
        return sb.toString();
    }
}

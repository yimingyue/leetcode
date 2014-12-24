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
        // keypoint - convert it to long to avoid integer overflow issues
        long n = (long)numerator;
        long d = (long)denominator;
        if ((n > 0) ^ (d > 0))
            sb.append('-');
        n = Math.abs(n);
        d = Math.abs(d);

        sb.append(n/d);
        n = n % d;
        if (n == 0)
            return sb.toString();
        sb.append('.');
        Map<Long, Integer> map = new HashMap<> ();
        int offset = sb.length();
        map.put(n, offset);
        while (n != 0) {
            n = n * 10;
            sb.append(n / d);
            n = n % d;
            if (map.containsKey(n)) {
                offset = map.get(n);
                // keypoint - find the beginning of the loop part
                sb.insert(offset, '(');
                sb.append(')');
                return sb.toString();
            } else
                map.put(n, ++offset);
        }
        return sb.toString();
    }
}

/*
The key points of the problem;
 1) convert numerator and denominator to long to avoid overflow issues
 2) have a has map to capture repeat of the remainder and the offset
*/
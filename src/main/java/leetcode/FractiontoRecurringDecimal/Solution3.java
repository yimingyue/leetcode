package leetcode.FractiontoRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution3 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numer = (long)numerator;
        long denom = (long)denominator;
        if (numer % denom == 0)
            return String.valueOf(numer / denom);

        StringBuilder sb = new StringBuilder();
        if (numer < 0 ^ denom < 0)
            sb.append('-');
        numer = Math.abs(numer);
        denom = Math.abs(denom);
        sb.append(numer / denom);
        sb.append('.');
        numer %= denom;
        Map<Long, Integer> map = new HashMap<>();

        while (numer != 0 && !map.containsKey(numer)) {
            map.put(numer, sb.length());
            numer *= 10;
            sb.append(numer / denom);
            numer %= denom;
        }
        if (numer == 0)
            return sb.toString();
        sb.insert((int)map.get(numer), '(');
        sb.append(')');
        return sb.toString();
    }
}

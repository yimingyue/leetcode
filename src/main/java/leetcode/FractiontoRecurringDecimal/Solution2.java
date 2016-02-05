package leetcode.FractiontoRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 1/18/16.
 */
public class Solution2 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long number = (long)numerator;
        if (number * denominator < 0 && number/denominator == 0)
            sb.append("-0");
        else
            sb.append(number/denominator);
        if (number % denominator == 0)
            return sb.toString();
        sb.append('.');
        number = number % denominator;
        Map<Long, Integer> map = new HashMap<>();
        while (number != 0) {
            if (map.containsKey(number)) {
                sb.insert(map.get(number), "(");
                sb.append(')');
                break;
            } else {
                map.put(number, sb.length());
                number *= 10;
                sb.append(Math.abs(number/denominator));
                number = number % denominator;
            }
        }
        return sb.toString();
    }
}

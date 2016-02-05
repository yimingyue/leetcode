package leetcode.BasicCalculator;

/**
 * Created by ymyue on 1/11/16.
 */
public class Solution2 {
    public int calculate(String s) {
        Character operator = null;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(s.charAt(i))) {
                int num = ch - '0';
                int j = i+1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num *= 10;
                    num += s.charAt(j) - '0';
                    j++;
                }
                if (operator == null)
                    result = num;
                else if ('+' == operator)
                    result += num;
                else if ('-' == operator)
                    result -= num;
                i = j-1;
            } else if (s.charAt(i) == '+') {
                operator = '+';
            } else if (s.charAt(i) == '-') {
                operator = '-';
            } else if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '(') {
                int count = 1;
                for (int j = i+1; j < s.length(); j++) {
                    if (s.charAt(j) == '(')
                        ++count;
                    else if (s.charAt(j) == ')')
                        --count;
                    if (count == 0) {
                        int num = calculate(s.substring(i+1, j));
                        if (operator == null)
                            result = num;
                        else if ('+' == operator)
                            result += num;
                        else if ('-' == operator)
                            result -= num;
                        i = j;
                        break;
                    }
                }
            }
        }
        return result;
    }
}

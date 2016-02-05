package leetcode.ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 1/14/16.
 Question:
 Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Examples:
 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []

 Analysis:
 2 steps to get the result from the input string: 1. split the string. 2. add binary operators

 Idea:
 DFS. for each position which can add an operator, add an operator and dfs. split string into two parts, prefix suffix. get all the possible result can be formed from suffix and recursive on prefix.
 But there could be 2 + 3 * 2 case which should not be split on 23 2 and recursive on 23.
 The solution is recursive only with '+' or '-' operator. For any '*' operator, it has to be left in the suffix.


 special cases:
 1. non-zero number can't start with 0, e.g. 105 can't be split to 1 05. solution - split it to 0 5
 2. number overflow is possible. e.g. 3456237490

 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<> ();
        if (num.isEmpty())
            return list;
        helper(list, 0, "", 0, "", num, target);
        return list;
    }

    private void helper(List<String> rList, int left, String first, int right, String second, String third, int target) {
        if (third.isEmpty()) {// reach the end of the original String
            if (second.isEmpty()) { // no '+' or '-' in the expression
                if (left == target) {
                    rList.add(first);
                }
            } else { // has '+' or '-' in the expression
                if (Integer.MIN_VALUE + right <= left && left - right == target) {
                    rList.add(first + '-' + second);
                }
                if (Integer.MAX_VALUE - right >= left && left + right == target) {
                    rList.add(first + '+' + second);
                }
            }
        } else {
            int number = 0;
            for (int i = 0; i < third.length(); i++) {
                if (i > 0 && number == 0)
                    return;
                int digit = third.charAt(i) - '0';
                if (number > Integer.MAX_VALUE / 10 || (number == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                    return;
                number = number * 10 + digit;
                String prefix = third.substring(0, i+1);
                String suffix = third.substring(i+1);
                if (first.isEmpty()) // from the beginning
                    helper(rList, number, prefix, right, second, suffix, target);
                else if (second.isEmpty()) { // has no '+' or '-' in the expression yet
                    if (left == 0 || number < Integer.MAX_VALUE / left || (number == Integer.MAX_VALUE / left && Integer.MAX_VALUE % left == 0)) {
                        helper(rList, left * number, first + '*' + prefix, right, second, suffix, target);
                    }
                    helper(rList, left, first, number, prefix, suffix, target);  // add '+' or '-' at position i
                } else { // already has '+' or '-' in the expression
                    if (Integer.MAX_VALUE - right >= left)
                        helper(rList, left + right, first + '+' + second, number, prefix, suffix, target); // merge first and second by '+', add '+' or '-' at position i
                    if (Integer.MIN_VALUE + right <= left)
                        helper(rList, left - right, first + '-' + second, number, prefix, suffix, target); // merge first and second by '-', add '+' or '-' at position i
                    if (number == 0 || Integer.MAX_VALUE / number > right || (Integer.MAX_VALUE / number == right && Integer.MAX_VALUE % number == 0)) { // add '*' add position i
                        helper(rList, left, first, right * number, second + '*' + prefix, suffix, target);
                    }
                }
            }
        }
    }
}

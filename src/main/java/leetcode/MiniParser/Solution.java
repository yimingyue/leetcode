package leetcode.MiniParser;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 9/18/16.
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> stack = new ArrayDeque<> ();
        int number = 0;
        int flag = 1;
        NestedInteger nestedInteger = null;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number *= 10;
                number += ch - '0';
                if (nestedInteger == null) {
                    nestedInteger = new NestedInteger(flag * number);
                    if (!stack.isEmpty())
                        stack.peek().add(nestedInteger);
                } else {
                    nestedInteger.setInteger(flag * number);
                }
            } else if (ch == '-') {
                flag = -1;
            } else if (ch == '[') {
                nestedInteger = new NestedInteger();
                if (!stack.isEmpty())
                    stack.peek().add(nestedInteger);
                stack.push(nestedInteger);
                nestedInteger = null;
            } else if (ch == ']') {
                nestedInteger = stack.pop();
            } else if (ch == ',') {
                number = 0;
                flag = 1;
                nestedInteger = null;
            }
        }
        return nestedInteger;
    }
}

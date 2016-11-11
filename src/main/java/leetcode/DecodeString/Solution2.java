package leetcode.DecodeString;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 10/7/16.
 */
public class Solution2 {
    public String decodeString(String s) {
        String str = "";
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<String> prefixStack = new ArrayDeque<> ();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num *= 10;
                num += ch - '0';
            } else if (Character.isAlphabetic(ch)) {
                str += ch;
            } else if (ch == '[') {
                stack.push(num);
                num = 0;
                prefixStack.push(str);
                str = "";
            } else if (ch == ']') {
                String prefix = prefixStack.pop();
                num = stack.pop();
                while (num > 0) {
                    prefix += str;
                    num--;
                }
                str = prefix;
            }
        }
        return str;
    }
}

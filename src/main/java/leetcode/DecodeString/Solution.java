package leetcode.DecodeString;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 9/17/16.
 * Time complexity: O(n);
 * Space complexity: O(n)
 */
public class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<String> strs = new ArrayDeque<> ();
        int i = 0;
        int number = 0;
        String str = "";
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number *= 10;
                number += ch - '0';
            } else if (ch == '[') {
                counts.push(number);
                number = 0;
                strs.push(str);
                str = "";
            } else if (ch == ']') {
                int count = counts.pop();
                String prefix = strs.pop();
                while (count-- > 0)
                    prefix += str;
                str = prefix;
            } else {
                str += ch;
            }
            i++;
        }
        return str;
    }
}

package interview.amazon.test1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 1/11/16.
 */
public class Solution {
    static String firstRepeatedWord(String s) {
        Set<String> set = new HashSet<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ' || ch == '\t' || ch == ',' || ch == ':' || ch == ';' || ch == '-' || ch == '.') {
                if (i > start) {
                    String str = s.substring(start, i);
                    if (set.contains(str))
                        return str;
                    set.add(str);
                }
                start = i+1;
            }
        }
        return "";
    }
}

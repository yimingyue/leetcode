package leetcode.ZigZagConversion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 5/17/15.
 */
public class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>(numRows);
        if (numRows == 1)
            return s;
        for (int i = 0; i < numRows; i++)
            list.add(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            int index = i % (numRows * 2 - 2);
            if (index < numRows) {
                list.get(index).append(s.charAt(i));
            } else {
                list.get(numRows - (index-numRows+2)).append(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder sb : list)
            builder.append(sb.toString());
        return builder.toString();
    }
}

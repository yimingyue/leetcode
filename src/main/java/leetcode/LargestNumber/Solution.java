package leetcode.LargestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ymyue on 10/31/15.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num: nums)
            list.add(Integer.toString(num));
        Collections.sort(list, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : list)
            sb.append(str);
        if (sb.length() > 0 && sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}

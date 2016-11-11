package leetcode.LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ymyue on 5/25/16.
 */
public class Solution2 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = Integer.toString(nums[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String first = x + y;
                String second = y + x;
                return second.compareTo(first);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs)
            sb.append(str);
        if (sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}
/*
Time complexity: O(nlgn) - Sort
Space complexity: O(1)

Notes:
    1. corner case [0, 0] - should return 0 instead of 00. More generally - trim the leading 0s for any string that representing a number. An even better idea - if the leading character is '0', return "0". Because if '0' is the first character, then all the characters afterwards has to be 0
    2. can't sort int type with custom comparator, have to convert to Object types. More generally - Can't use custom comparator to sort primitive type in an array
    3. sort in descending order, not ascending order
    4. instead of comparing two Strings character by character, use the compareTo method of String can yield a better performance
*/
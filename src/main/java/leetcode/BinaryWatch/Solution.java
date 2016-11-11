package leetcode.BinaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 9/17/16.
 */
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        helper(result, 0, num, 0, 10);
        return result;
    }

    private void helper(List<String> result, int val, int left, int index, int length) {
        if (left == 0) {
            int h = val >> 6;
            int m = val & 0x3F;
            if (h < 12 && m < 60)
                result.add(""+h+":"+ (m < 10 ? "0"+m : m));
            return;
        }
        for (int i = index; i <= length-left; i++)
            helper(result, val + (1 << i), left-1, i+1, length);
    }
}

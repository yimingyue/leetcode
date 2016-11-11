package leetcode.PalindromePermutation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        for (int value : map.values()) {
            if (value % 2 == 1)
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }
}

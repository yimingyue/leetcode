package leetcode.StrobogrammaticNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/14/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>(5);
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int i = 0; int j = num.length()-1;
        while (i <= j) {
            char ch1 = num.charAt(i);
            char ch2 = num.charAt(j);
            if (!map.containsKey(ch1) || map.get(ch1) != ch2)
                return false;
            i++;
            j--;
        }
        return true;
    }
}

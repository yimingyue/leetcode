package leetcode.java8.ValidAnagram;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ymyue on 5/31/16.
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        Map<Character, Long> map = s.chars().parallel().mapToObj(i -> (char)i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        t.chars().mapToObj(i -> (char)i).forEach(k -> map.merge(k, (long) -1, (x, y) -> x + y));
        return !map.values().stream().anyMatch(x -> x < 0);
    }
}

/**
 * Time complexity: O(n)
 * Space Complexity O(n)
 */

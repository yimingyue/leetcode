package leetcode.RearrangeStringkDistanceApart;

import java.util.*;

/**
 * Created by ymyue on 6/14/16.
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
public class Solution {
    public String rearrangeString(String str, int k) {
        if (str == null || str.isEmpty())
            return "";
        if (k < 2)
            return str;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int buckets = str.length() / k + (str.length() % k == 0 ? 0 : 1);
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (x, y) -> map.get(y) - map.get(x));
        if (map.get(list.get(0)) == 1)
            return str;
        int lastBucket = str.length() - (buckets-1)*k;
        if (map.get(list.get(0)) > buckets || (list.size() > lastBucket && map.get(list.get(lastBucket)) == buckets))
            return "";
        char[] result = new char[str.length()];
        int j = 0;
        int r = 0;
        for (Character ch : list) {
            for (int i = 0; i < map.get(ch); i++) {
                result[j] = ch;
                j += k;
                if (j >= result.length)
                    j = ++r;
            }
        }
        return String.valueOf(result);
    }
}

package leetcode.RearrangeStringkDistanceApart;

import java.util.*;

/**
 * Created by ymyue on 6/15/16.
 */
public class Solution2 {
    public String rearrangeString(String str, int k) {
        if (str == null || str.isEmpty())
            return "";
        if (k < 2)
            return str;
        int length = str.length();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> map.get(y) == map.get(x) ? x - y : map.get(y) - map.get(x));
        for (Character ch : map.keySet())
            pq.offer(ch);

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            List<Character> list = new ArrayList<>();
            int count = Math.min(k, length);
            for (int i = 0; i < count; i++) {
                if (pq.isEmpty())
                    return "";
                char ch = pq.poll();
                sb.append(ch);
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) > 0)
                    list.add(ch);
                length--;
            }
            for (Character ch : list)
                pq.offer(ch);
        }
        return sb.toString();
    }
}

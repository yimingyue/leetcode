package leetcode.AlienDictionary;

import java.util.*;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution3 {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer>  count = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                map.putIfAbsent(ch, new ArrayList<>());
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                transform(words[i], words[j], map, count);
            }
        }
        Queue<Character> queue = new ArrayDeque<>();
        for (Character ch : count.keySet()) {
            if (count.get(ch) == 0)
                queue.offer(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character ch = queue.poll();
            sb.append(ch);
            for (Character next : map.get(ch)) {
                count.put(next, count.get(next)-1);
                if (count.get(next) == 0) {
                    queue.offer(next);
                }
            }
            map.remove(ch);
        }
        return map.isEmpty() ? sb.toString() : "";
    }

    private void transform(String str1, String str2, Map<Character, List<Character>> map, Map<Character, Integer> count) {
        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) != str2.charAt(i)) {
                map.get(str1.charAt(i)).add(str2.charAt(i));
                if (!count.containsKey(str1.charAt(i)))
                    count.put(str1.charAt(i), 0);
                count.put(str2.charAt(i), count.getOrDefault(str2.charAt(i), 0)+1);
                break;
            }
            i++;
        }
    }
}

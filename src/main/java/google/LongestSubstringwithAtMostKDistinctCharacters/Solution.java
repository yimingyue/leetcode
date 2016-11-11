package google.LongestSubstringwithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by ymyue on 10/10/16.
 * http://www.1point3acres.com/bbs/thread-200339-1-1.html
 * Round 3
 * This solution is for the follow up question.
 */
public class Solution {
    public int longestSubString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<> ((x, y) -> map.get(x) - map.get(y));

        int j = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                pq.remove(ch);
                map.put(ch, i);
                pq.offer(ch);
            } else {
                map.put(ch, i);
                pq.offer(ch);
                if (map.size() > k) {
                    char c = pq.poll();
                    j = map.get(c) + 1;
                    map.remove(c);
                }
            }
            maxLength = Math.max(maxLength, i-j+1);
        }
        return maxLength;
    }
}

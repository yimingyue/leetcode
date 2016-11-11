package leetcode.LongestRepeatingCharacterReplacement;

import java.util.PriorityQueue;

/**
 * Created by ymyue on 10/18/16.
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxLength = 0;
        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> counts[y-'A'] - counts[x-'A']);

        int i = 0;
        int j = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            pq.remove(ch);
            counts[ch - 'A']++;
            pq.offer(ch);
            int maxCount = counts[pq.peek()-'A'];
            while (i-j+1-maxCount > k) {
                char chj = s.charAt(j++);
                pq.remove(chj);
                if (--counts[chj-'A'] != 0)
                    pq.offer(chj);
                maxCount = counts[pq.peek()-'A'];
            }
            maxLength = Math.max(maxLength, i - j + 1);
            i++;
        }
        return maxLength;
    }
}

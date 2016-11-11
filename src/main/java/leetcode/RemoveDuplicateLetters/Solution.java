package leetcode.RemoveDuplicateLetters;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 7/17/16.
 * Time complexity: O(n)
 * Space compexity: O(n)
 */
public class Solution {
    private static final int len = 26;
    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty())
            return s;
        int[] count = new int[len];
        for (char ch : s.toCharArray())
            count[ch - 'a']++;
        boolean[] inQueue = new boolean[len];
        StringBuilder sb = new StringBuilder();
        Deque<Character> queue = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (count[idx] > 0) {
                if (!inQueue[idx]) {
                    while (!queue.isEmpty() && queue.peekLast() >= ch)
                        inQueue[queue.pollLast() - 'a'] = false;
                    queue.offer(ch);
                    inQueue[idx] = true;
                }
                if (--count[idx] == 0) {
                    while (!queue.isEmpty()) {
                        char c = queue.poll();
                        sb.append(c);
                        count[c - 'a'] = 0;
                        if (c == ch)
                            break;
                    }
                }
            }
        }
        return sb.toString();
    }
}

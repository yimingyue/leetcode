package leetcode.AlienDictionary;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ymyue on 8/1/16.
 */
public class Solution2 {
    private static final int len = 26;
    public String alienOrder(String[] words) {
        int[] inDegrees = new int[len];
        boolean[] b = new boolean[len];
        boolean[][] matrix = new boolean[len][len];
        int count = countUniqueChar(words, b);
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                build(words[j], words[i], inDegrees, matrix);
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (inDegrees[i] == 0 && b[i])
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            count -= size;
            for (int i = 0; i < size; i++) {
                int j = queue.poll();
                sb.append((char)('a' + j));
                for (int k = 0; k < len; k++) {
                    if (matrix[j][k]) {
                        inDegrees[k]--;
                        if (inDegrees[k] == 0)
                            queue.offer(k);
                    }
                }
            }
        }
        return count == 0 ? sb.toString() : "";
    }

    private void build(String s, String t, int[] inDegrees, boolean matrix[][]) {
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            int prev = s.charAt(i) - 'a';
            int next = t.charAt(i) - 'a';
            if (prev != next) {
                if (!matrix[prev][next]) {
                    inDegrees[next]++;
                    matrix[prev][next] = true;
                }
                break;
            }
        }
    }

    private int countUniqueChar(String[] words, boolean[] arr) {
        int count = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (!arr[ch-'a']) {
                    count++;
                    arr[ch-'a'] = true;
                }
            }
        }
        return count;
    }
}

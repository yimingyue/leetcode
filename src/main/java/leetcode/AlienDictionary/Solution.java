package leetcode.AlienDictionary;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ymyue on 2/9/16.
 * Revised by ymyue on 7/11/17
 */
public class Solution {
    private static final int alphabetLength = 26;
    public String alienOrder(String[] words) {
        int[] inDegrees = new int[alphabetLength];
        boolean[][] matrix = new boolean[alphabetLength][alphabetLength];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                inDegrees[ch-'a'] = 1;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                buildEdge(words[i], words[j], matrix, inDegrees);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int totalCount = 0;
        for (int i = 0; i < alphabetLength; i++) {
            if (inDegrees[i] == 1) {
                queue.offer(i);
            }
            if (inDegrees[i] != 0)
                totalCount++;
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int count = queue.size();
            totalCount -= count;
            for (int k = 0; k < count; k++) {
                int i = queue.poll();
                inDegrees[i]--;
                sb.append((char)('a'+i));
                for (int j = 0; j < alphabetLength; j++) {
                    if (matrix[i][j]) {
                        inDegrees[j]--;
                        if (inDegrees[j] == 1)
                            queue.offer(j);
                    }
                }
            }
        }
        return totalCount == 0 ? sb.toString() : "";
    }

    private void buildEdge(String smaller, String larger, boolean[][] matrix, int[] inDegrees) {
        int i = 0;
        while (i < larger.length() && i < smaller.length()) {
            char chl = larger.charAt(i);
            char chs = smaller.charAt(i);
            if (matrix[chs-'a'][chl-'a'])
                return;
            if (chl != chs) {
                inDegrees[chl-'a']++;
                matrix[chs-'a'][chl-'a'] = true;
                break;
            }
            i++;
        }
    }
}

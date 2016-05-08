package leetcode.AlienDictionary;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by ymyue on 2/9/16.
 */
public class Solution {
    public String alienOrder(String[] words) {
        int[] degree = new int[26];
        Arrays.fill(degree, -1);
        boolean[][] matrix = new boolean[26][26];
        for (int i = 0; i < words.length; i++) {
            char[] ci = words[i].toCharArray();
            for (char ch : ci) {
                if (degree[ch-'a'] == -1)
                    degree[ch-'a'] = 0;
            }
            for (int j = i+1; j < words.length; j++) {
                char[] cj = words[j].toCharArray();

                for (char ch : cj) {
                    if (degree[ch-'a'] == -1)
                        degree[ch-'a'] = 0;
                }
                for (int k = 0; k < ci.length && k < cj.length; k++) {
                    if (ci[k] != cj[k]) {
                        if (!matrix[ci[k]-'a'][cj[k]-'a']) {
                            matrix[ci[k]-'a'][cj[k]-'a'] = true;
                            degree[cj[k]-'a']++;
                        }
                        break;
                    }
                }
            }
        }
        LinkedList<Integer> queue = new LinkedList<> ();
        int count = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0)
                queue.offer(i);
            if (degree[i] != -1)
                count++;
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int val = queue.poll();
            sb.append((char)('a'+val));
            for (int j = 0; j < matrix[val].length; j++) {
                if (matrix[val][j]) {
                    degree[j]--;
                    if (degree[j] == 0)
                        queue.offer(j);
                }
            }
        }
        if (sb.length() == count)
            return sb.toString();
        else
            return "";
    }
}

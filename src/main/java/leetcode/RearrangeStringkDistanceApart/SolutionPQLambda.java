package leetcode.RearrangeStringkDistanceApart;

import java.util.*;

/**
 * Created by ymyue on 7/26/16.
 * Time complexity: O(n)
 */
public class SolutionPQLambda {
    private static final int len = 26;
    public String rearrangeString(String str, int k) {
        if (k < 2)
            return str;

        int[] count = new int[len];
        Arrays.fill(count, 0);
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray())
            count[ch-'a']++;

        Queue<Integer> queue = new PriorityQueue<>((x, y) -> count[x] == count[y] ? x - y : count[y] - count[x]);
        for (int i = 0; i < len; i++)
            if (count[i] > 0)
                queue.offer(i);

        int length = str.length();
        while (length > 0) {
            int size = Math.min(length, k);
            if (queue.size() < size)    // aabbcc 4
                return "";
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int j = queue.poll();
                sb.append((char)('a' + j));
                if (--count[j] > 0)
                    list.add(j);
            }
            length -= size;
            queue.addAll(list);
        }
        return sb.toString();
    }
}

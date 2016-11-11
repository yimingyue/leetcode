package leetcode.RearrangeStringkDistanceApart;

import java.util.*;

/**
 * Created by ymyue on 10/1/16.
 */
public class Solution3 {
    public static class Pair implements Comparable<Pair> {
        char ch;
        int count;

        @Override
        public int compareTo(Pair p) {
            return this.count == p.count ? this.ch - p.ch : p.count - this.count;
        }

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String rearrangeString(String str, int k) {
        StringBuilder sb = new StringBuilder();

        int[] count = new int[26];
        int[] index = new int[26];
        for (char ch : str.toCharArray())
            count[ch-'a']++;
        Arrays.fill(index, -k);

        while (sb.length() < str.length()) {
            PriorityQueue<Pair> pq = new PriorityQueue<> ();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0 && sb.length() - index[i] >= k)
                    pq.offer(new Pair((char)(i+'a'), count[i]));
            }
            if (pq.isEmpty())
                return "";
            else {
                Pair p = pq.poll();
                index[p.ch-'a'] = sb.length();
                sb.append(p.ch);
                p.count--;
                count[p.ch-'a']--;
            }
        }
        return sb.toString();
    }
}

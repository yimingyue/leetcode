package leetcode.RearrangeStringkDistanceApart;

import java.util.*;

/**
 * Created by ymyue on 7/25/16.
 */
public class SolutionPQ {
    class Char implements Comparable {
        char ch;
        int count;

        public Char(char ch, int c){
            this.ch = ch;
            this.count = c;
        }

        @Override
        public int compareTo(Object o) {
            Char c = (Char)o;
            if (this.count < c.count)
                return 1;
            else if (this.count > c.count)
                return -1;
            if (this.ch < c.ch)
                return -1;
            else if (this.ch > c.ch)
                return 1;
            return 0;
        }
    }

    public String rearrangeString(String str, int k) {
        if (k == 0)
            return str;
        Map<Character, Integer> map = new HashMap<> ();
        for (char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        Queue<Char> queue = new PriorityQueue<> ();
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            queue.offer(new Char(entry.getKey(), entry.getValue()));

        StringBuilder sb = new StringBuilder();
        int len = str.length();
        while (len > 0) {
            int size = Math.min(len, k);
            List<Char> list = new ArrayList<> ();
            if (queue.size() < size)
                return "";
            for (int i = 0; i < size; i++) {
                Char c = queue.poll();
                sb.append(c.ch);
                if (c.count > 1) {
                    c.count--;
                    list.add(c);
                }
            }
            queue.addAll(list);
            len -= size;
        }
        return sb.toString();
    }
}

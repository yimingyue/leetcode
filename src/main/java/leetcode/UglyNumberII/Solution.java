package leetcode.UglyNumberII;

import java.util.LinkedList;

/**
 * Created by ymyue on 1/19/16.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        LinkedList<Integer> queue1 = new LinkedList<> ();
        queue1.offer(2);
        LinkedList<Integer> queue2 = new LinkedList<> ();
        queue2.offer(3);
        LinkedList<Integer> queue3 = new LinkedList<> ();
        queue3.offer(5);
        int count = 1;
        int r = 0;
        while (count < n) {
            int a = queue1.peek();
            int b = queue2.peek();
            int c = queue3.peek();
            r = Math.min(Math.min(a, b), c);
            if (a == r)
                queue1.poll();
            if (b == r)
                queue2.poll();
            if (c == r)
                queue3.poll();
            queue1.offer(r * 2);
            queue2.offer(r * 3);
            queue3.offer(r * 5);
            count++;
        }
        return r;
    }
}

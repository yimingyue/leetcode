package leetcode.TheSkylineProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by ymyue on 1/25/16.
 */
public class Solution {
    private class Rectangle implements Comparable<Rectangle> {
        int l;
        int r;
        int h;
        public Rectangle(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
        public int compareTo(Rectangle c) {
            if (this.l != c.l)
                return this.l - c.l;
            if (this.r != c.r)
                return this.r - c.r;
            return this.h - c.h;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        TreeSet<Rectangle> tSet = new TreeSet<> ();
        for (int[] building : buildings) {
            tSet.add(new Rectangle(building[0], building[1], building[2]));
        }
        List<int[]> list = new ArrayList<>();
        if (tSet.isEmpty())
            return list;
        Rectangle pre = tSet.pollFirst();
        while (!tSet.isEmpty()) {
            Rectangle cur = tSet.pollFirst();
            if (pre.r >= cur.r && pre.h >= cur.h) {
                continue;
            } else if (pre.r >= cur.r && pre.h < cur.h) {
                if (pre.l < cur.l)
                    list.add(new int[] {pre.l, pre.h});
                if (cur.r < pre.r)
                    tSet.add(new Rectangle(cur.r, pre.r, pre.h));
                pre = cur;
            } else if (pre.r > cur.l && pre.r < cur.r) {
                if (pre.h == cur.h)
                    pre.r = cur.r;
                else if (pre.h < cur.h) {
                    if (pre.l < cur.l)
                        list.add(new int[] {pre.l, pre.h});
                    pre = cur;
                } else {
                    tSet.add(new Rectangle(pre.r, cur.r, cur.h));
                }
            } else if (pre.r == cur.l) {
                if (pre.h == cur.h)
                    pre.r = cur.r;
                else {
                    list.add(new int[] {pre.l, pre.h});
                    pre = cur;
                }
            } else {
                list.add(new int[]{pre.l, pre.h});
                list.add(new int[]{pre.r, 0});
                pre = cur;
            }
        }
        list.add(new int[]{pre.l, pre.h});
        list.add(new int[]{pre.r, 0});
        return list;
    }
}

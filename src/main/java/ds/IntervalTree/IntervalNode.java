package ds.IntervalTree;

import ds.Interval;

/**
 * Created by ymyue on 10/16/16.
 */
public class IntervalNode {
    Interval interval;
    int max;
    IntervalNode left, right;

    public IntervalNode(Interval interval) {
        this.interval = new Interval(interval);
        this.max = interval.end;
    }

    public IntervalNode insert(IntervalNode root, Interval interval) {
        if (root == null)
            return new IntervalNode(interval);
        if (interval.start < root.interval.end)
            root.left = insert(root.left, interval);
        else
            root.right = insert(root.right, interval);
        if (root.max < interval.end)
            root.max = interval.end;
        return root;
    }

    public boolean isOverlap(IntervalNode root, Interval interval) {
        if (root == null)
            return false;
        if (isOverlap(root.interval, interval))
            return true;
        if (root.left != null && interval.end <= root.left.max)
            return isOverlap(root.left, interval);
        else
            return isOverlap(root.right, interval);
    }

    private boolean isOverlap(Interval interval1, Interval interval2) {
        return !(interval1.end < interval2.start || interval1.start > interval2.end);
    }
}

package google.SumOfValueInRectangle;

/**
 * Created by ymyue on 10/7/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=194075 - Round one
 */
public class Solution {
    public static class QuadTree {
        int x;
        int y;
        int val;
        QuadTree leftDown;
        QuadTree rightDown;
        QuadTree leftUp;
        QuadTree rightUp;

        public QuadTree(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private QuadTree root;

    public void add(int x, int y, int val) {

    }

    public int get(int x1, int y1, int x2, int y2) {
        return get(root, x1, y1, x2, y2);
    }

    private QuadTree add(QuadTree root, int x, int y, int val) {
        if (root == null) {
            root = new QuadTree(x, y, val);
        } else {
            if (root.x == x && root.y == y)
                root.val += val;
            else if (x <= root.x && y <= root.y) {
                root.leftDown = add(root.leftDown, x, y, val);
            } else if (x <= root.x && y > root.y) {
                root.leftUp = add(root.leftUp, x, y, val);
            } else if (x > root.x && y <= root.y) {
                root.rightDown = add(root.rightDown, x, y, val);
            } else
                root.rightUp = add(root.rightUp, x, y, val);
        }
        return root;
    }

    private int get(QuadTree root, int x1, int y1, int x2, int y2) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.x >= x1 && root.y >= y1 && root.x <= x2 && root.y <= y2)
            sum += root.val;
        if (root.x >= x1 && root.y >= y1)
            sum += get(root.leftDown, x1, y1, x2, y2);
        if (root.x <= x2 && root.y >= y2)
            sum += get(root.rightDown, x1, y1, x2, y2);
        if (root.x >= x1 && root.y <= y2)
            sum += get(root.leftUp, x1, y1, x2, y2);
        if (root.x <= x2 && root.y <= y2)
            sum += get(root.rightUp, x1, y1, x2, y2);
        return sum;
    }
}

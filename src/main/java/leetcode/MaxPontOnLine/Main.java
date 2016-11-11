package leetcode.MaxPontOnLine;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/26/13
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] argvs) {
        int num = 4;
        Point[] points = new Point[num];
        for (int i = 0; i < num; i++) {
            Point a = new Point(3, 1);
            Point b = new Point(12, 3);
            Point c = new Point(3, 1);
            Point d = new Point(-6, -1);
            points[0] = a;
            points[1] = b;
            points[2] = c;
            points[3] = d;
//            Point p = new Point(x, y);
//            System.out.println("x=" + x + " y=" + y);
//            points[i] = p;
        }

        Solution s = new Solution();
        System.out.println(s.maxPoints(points));
    }
}

package leetcode.MaxPontOnLine;/*
 * Iterate the point array to make the points distinct.
 * For each point p, iterate the lines. If it's on the line, add it to the line. If it's not on the line, construct a line with each     point on the line.
 * Add the new lines to the line set
*/

import java.util.*;

public class Solution {

    public int maxPoints(Point[] points) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same MaxPontOnLine.Threesum.ZigzagIterator instance will be reused for each test case.

        // no point at all
        if (points.length == 0)
            return 0;

        // initialization
        initialization(points);

        // all points on the same coordinate
        if (dPoints.size() == 1)
            return points.length;

        // Iterate the points and add each point to the existing lines
        Iterator iter = dPoints.iterator();
        while (iter.hasNext()) {
            Point p = (Point)iter.next();
            addToLines(p);
        }

        int max = 0;
        Iterator<Line> lIter = lines.iterator();
        while (lIter.hasNext()) {
            Line l = lIter.next();
            int pointCount = l.getPointCount();
            if (max < pointCount)
                max = pointCount;
        }
        return max;
    }

    private void initialization(Point [] points) {
        lines = new ArrayList<Line>();
        dPoints = new ArrayList<Point>();
        pointCount = new HashMap<Point, Integer>();
        cPoints = new HashSet<Point>();

        for (int i = 0; i < points.length; i++) {
            Iterator iter = dPoints.iterator();
            boolean distinct = true;
            while (iter.hasNext()) {
                Point p = (Point) iter.next();
                if (p.x == points[i].x && p.y == points[i].y) {
                    if (pointCount.containsKey(p))
                        pointCount.put(p, pointCount.get(p) + 1);
                    else
                        pointCount.put(p, 1);   // the number is addtional count not total count
                    distinct = false;
                    break;
                }
            }
            if (distinct)
                dPoints.add(points[i]);
        }
    }

    private void addToLines(Point p) {
        oPoints = new HashSet<Point>(cPoints);
        for (Line l : lines) {
            if (l.isOnTheLine(p)) {
                l.addToTheLine(p);
                ArrayList<Point> linePoints = l.getPoints();
                Iterator<Point> iter = linePoints.iterator();
                while (iter.hasNext()) {
                    oPoints.remove((Point)iter.next());
                }
            }
        }
        cPoints.add(p);

        Iterator<Point> iter = oPoints.iterator();
        while (iter.hasNext()) {
            Point r = (Point) iter.next();
            Line line = new Line(p, r);
            lines.add(line);
        }
    }

    private class Line {
        int x1;
        int y1;
        int x0;
        int y0;
        int lPointCount = 0;
        ArrayList<Point> points;
        int lineType; // 0 - normal; 1 - horizontal; 2 - vertical; -1 - degenerated
        Line(Point m, Point n) {
            if (m.x == n.x && m.y == n.y) {
                lineType = -1;
                x0 = m.x;
                y0 = m.y;
            }
            else if (m.x == n.x) {
                lineType = 2;
                x0 = m.x;
            } else if (m.y == n.y) {
                lineType = 1;
                y0 = m.y;
            }
            else {
                x0 = m.x;
                y0 = m.y;
                x1 = n.x;
                y1 = n.y;
                lineType = 0;
            }
            points  = new ArrayList<Point> ();
            lPointCount = 2;
            if (pointCount.containsKey(m))
                lPointCount += pointCount.get(m);
            if (pointCount.containsKey(n))
                lPointCount += pointCount.get(n);
            points.add(m);
            points.add(n);
        }

        public ArrayList<Point> getPoints() {
            return points;
        }

        public boolean isOnTheLine(Point p) {
            if (lineType == -1)
                return (p.x == x0 && p.y == y0);
            else if (lineType == 0) {
                return ((p.y - y0)*(x1-x0) == (p.x - x0)*(y1-y0));
            }
            else if (lineType == 1)
                return p.y == y0;
            else
                return p.x == x0;
        }

        public void addToTheLine(Point p) {
            lPointCount++;
            if (pointCount.containsKey(p))
                lPointCount += pointCount.get(p);
            points.add(p);
        }

        public int getPointCount() {
            return lPointCount;
        }
    }

    private ArrayList<Line> lines;
    private ArrayList<Point> dPoints; // distinct points
    private Map<Point, Integer> pointCount; // count of point with the same coordinate
    private Set<Point> cPoints; // candidate points
    private Set<Point> oPoints; // other points
}
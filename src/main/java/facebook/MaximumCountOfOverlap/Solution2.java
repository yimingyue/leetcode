package facebook.MaximumCountOfOverlap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/29/14
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    private class Node {
        int time;
        boolean type; // true - start; false - end
        public Node(int time, boolean type) {
            this.time = time;
            this.type = type;
        }
    }

    private class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.time != o2.time)
                return o1.time - o2.time;
            if (o1.type && !o2.type)
                return 1;
            if (!o1.type && o2.type)
                return -1;
            return 0;
        }
    }

    public int maxOverlapCount(List<Interval> list) {
        if (list.size() == 0)
            return 0;
        List<Node> nList = new ArrayList<>();
        for (Interval interval : list) {
            nList.add(new Node(interval.start, true));
            nList.add(new Node(interval.end, false));
        }
        Collections.sort(nList, new MyComparator());
        int max = 0;
        int count = 0;
        for (Node node : nList) {
            if (node.type)
                count++;
            else
                count--;
            max = Math.max(max, count);
        }
        return max;
    }
}

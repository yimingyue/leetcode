package facebook.MaximumCountOfOverlap;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/29/14
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */

import java.util.Collections;
import java.util.List;

/**
 * Question:     http://www.meetqun.com/thread-3421-1-6.html
 * 一堆会议安排，找到最大重叠数量，这样知道需要至少预定几个房间

 */
public class Solution {

    public int maxOverlapMeetings(List<Interval> list) {
        if (list.isEmpty())
            return 0;
        Collections.sort(list, new IntervalComparator());
        int[] counts = new int[list.size()];
        for (int i = 0;i < counts.length; i++)
            counts[i] = 1;  // be careful here. count the current one in.

        for (int i = 0; i < list.size(); i++) {
            Interval cur = list.get(i);
            for (int j = i+1; j < list.size(); j++) {
                Interval next = list.get(j);
                if (cur.end < next.start)
                    break;
                else {
                    counts[i] = counts[i] + 1;
                    counts[j] = counts[j] + 1;
                }
            }
        }
        int max = 0;
        for (int count : counts)
            max = Math.max(max, count);
        return max;
    }
}

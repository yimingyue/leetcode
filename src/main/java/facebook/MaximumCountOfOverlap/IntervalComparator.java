package facebook.MaximumCountOfOverlap;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/29/14
 * Time: 12:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.getStart() - o2.getStart();
    }
}

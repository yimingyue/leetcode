package facebook.MaximumConcatenateNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String maximumConcatenateNumber(int [] nums) {
        assert(nums.length > 0);
        List<Integer> list = new ArrayList<>(nums.length);
        for (int n : nums)
            list.add(n);
        Collections.sort(list, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (int n : list)
            sb.append(n);
        return sb.toString();
    }
    private class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            String s1 = b.toString() + a.toString();
            String s2 = a.toString() + b.toString();
            return s1.compareTo(s2);
        }
    }
}

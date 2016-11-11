package leetcode.TwoSumIIIDatastructuredesign;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 10/12/16.
 */
public class TwoSum {
    Set<Integer> nums;
    Set<Integer> sum;

    public TwoSum() {
        nums = new HashSet<>();
        sum = new HashSet<> ();
    }


    public void add(int num) {
        if (nums.contains(num))
            sum.add(num+num);
        else {
            for (int n : nums)
                sum.add(n + num);
            nums.add(num);
        }
    }

    public boolean find(int target) {
        return sum.contains(target);
    }
}
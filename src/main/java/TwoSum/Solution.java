package TwoSum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 3/14/14
 * Time: 11:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : numbers)
            set.add(i);

        int val = 0;
        for (int i : set) {
            if (set.contains(target-i)) {
                val = i;
                break;
            }
        }

        int [] rVal = new int [2];
        int k = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == val || numbers[i] == target-val)
                rVal[k++] = i+1;
        }
        return rVal;
    }
}
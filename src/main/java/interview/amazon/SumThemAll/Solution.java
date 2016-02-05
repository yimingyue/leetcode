package interview.amazon.SumThemAll;

/**
 * Created by ymyue on 1/11/16.
 */
public class Solution {
    static long sumOfIntegers(int[] arr) {
        long sum = 0;
        for (int val : arr)
            sum += (long) val;
        return sum;

    }
}

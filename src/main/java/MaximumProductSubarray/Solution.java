package MaximumProductSubarray;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/23/14
 * Time: 10:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0)
            return Integer.MIN_VALUE;
        int max = A[0];
        int total = 0;
        int left = 1;
        int right = 1;
        boolean leftEnds = false;
        boolean rightBegins = false;
        for (int value : A) {
            if (value == 0) {
                if (value > max)
                    max = value;
                total = 0;
                left = 1;
                right = 1;
                leftEnds = false;
                rightBegins = false;
            }
            else {
                if (total == 0) {
                    total = value;
                    left = value;
                    if (value < 0) {
                        leftEnds = true;
                        rightBegins = true;
                        right = value;
                    } else if (max < total)
                        max = total;
                } else {
                    total *= value;
                    if (!leftEnds)
                        left *= value;
                    if (value < 0) {
                        leftEnds = true;
                        rightBegins = true;
                        right = value;
                    } else if (rightBegins)
                        right *= value;

                    if (total > 0)
                        max = max > total ? max : total;
                    else {
                        int localProduct;
                        if (left < right)
                            localProduct = total / right;
                        else
                            localProduct = total / left;
                        max = max < localProduct ? localProduct : max;
                    }
                }
            }
        }
        return max;
    }
}

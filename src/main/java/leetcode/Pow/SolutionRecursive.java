package leetcode.Pow;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(logN)
 * Space complexity: O(logN)
 */
public class SolutionRecursive {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1/x;
        double val = myPow(x, n/2);
        return myPow(x, n%2) * val * val;
    }
}

package leetcode.Sqrt;

/**
 * Created by ymyue on 12/21/15.
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 0)
            return 0;
        int i = 1;
        while (x / i >= i) {
            i *= 2;
        }
        i /= 2;
        int result = 0;
        while (i > 0) {
            int tmp = result + i;
            if (x / tmp == tmp)
                return tmp;
            else if (x / tmp > tmp)
                result += i;
            i /= 2;
        }
        return result;
    }
}

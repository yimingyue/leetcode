package leetcode.SingleNumberII;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/3/14
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int singleNumber(int[] A) {
        int [] count = new int[32];
        for (int i = 0; i < count.length; i++)
            count[i] = 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1)
                    count[i]++;
            }
            result |= ((count[i]%3) << i);
        }
        return result;
    }
}

package google.CountOne;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/13/14
 * Time: 9:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}

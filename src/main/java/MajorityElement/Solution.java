package MajorityElement;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 11:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int majorityElement(int[] num) {
        assert(num.length > 0);
        int a = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (a != num[i]) {
                if (count == 0) {
                    a = num[i];
                    count++;
                }
                else
                    count--;
            } else
                count++;
        }
        return a;
    }
}

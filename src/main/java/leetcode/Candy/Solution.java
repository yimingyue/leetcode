package leetcode.Candy;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/11/14
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1)
            return 1;

        int rVal = 0;
        int val = 1;
        int flag = -1;
        for (int i = 0; i < ratings.length; i++) {
            if (i == ratings.length -1) {
                if (flag != i-1) {
                    rVal += i-1-flag;
                    if (val <= i-1-flag)
                        rVal++;
                } else
                    rVal += val;
                break;
            }
            if (ratings[i] < ratings[i+1]) {
                if (flag != i-1) {
                    rVal += i-1-flag;
                    if (val <= i-1-flag)
                        rVal++;
                    val=1;
                } else {
                    rVal += val;
                }
                val++;
                flag = i;
            } else if (ratings[i] == ratings[i+1]) {
                if (flag != i-1) {
                    rVal += i-1-flag;
                    if (val <= i-1-flag)
                        rVal++;
                } else {
                    rVal += val;
                }
                val=1;
                flag = i;
            } else {
                if (flag == i-1)
                    rVal += val;
                else {
                    rVal += (i-1-flag);
                    if (val <= i-1-flag)
                        rVal++;
                }
            }
        }
        return rVal;
    }
}

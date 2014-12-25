package leetcode.TwoSumIIInputarrayissorted;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] r = new int[2];
        int i = 0, j = numbers.length-1;
        int sum = 0;
        while (i < j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                r[0] = i+1;
                r[1] = j+1;
                break;
            } else if (sum > target)
                j--;
            else
                i++;
        }
        return r;
    }
}

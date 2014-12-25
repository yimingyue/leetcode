package leetcode.FindMinimuminRotatedSortedArrayII;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/23/14
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int findMin(int[] num) {
        assert (num.length > 0);
        int start = 0;
        int end = num.length -1;
        while (start < end && num[start] >= num[end]) {
            int mid = (start + end) / 2;
            if (num[mid] > num[end]) {
                start = mid + 1;
            } else if (num[mid] < num[start]) {
                end = mid;
            } else
                end = end - 1;
        }
        return num[start];
    }
}

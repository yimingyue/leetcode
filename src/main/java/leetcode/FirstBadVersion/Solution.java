package leetcode.FirstBadVersion;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class Solution {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (isBadVersion(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    boolean isBadVersion(int n) {
        return false;
    }
}

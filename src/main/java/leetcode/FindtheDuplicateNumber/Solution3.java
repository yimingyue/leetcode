package leetcode.FindtheDuplicateNumber;

/**
 * Created by ymyue on 6/26/16.
 * Time complexity: O(nlogN)
 * Space complexity: O(1)
 */
public class Solution3 {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid+1;
        }
        return low;
    }
}

package leetcode.WiggleSortII;

/**
 * Created by ymyue on 10/22/16.
 */
public class Solution4 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        int median = getMedian(nums);
        int upperStart = 1, upperEnd = n % 2 == 0 ? n-1 : n-2;
        int lowerStart = 0, lowerEnd = n % 2 == 0 ? n-2 : n-1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] > median) {
                swap(nums, i, upperStart);
                upperStart += 2;
                i--;
            } else if (i % 2 == 1 && nums[i] < median) {
                swap(nums, i, lowerEnd);
                lowerEnd -= 2;
                i--;
            }
        }
        int j = upperStart;
        for (int i = upperStart; i <= upperEnd; i += 2) {
            if (nums[i] > median) {
                swap(nums, i, j);
                j += 2;
            }
        }
        j = lowerEnd;
        for (int i = lowerEnd; i >= lowerStart; i -= 2) {
            if (nums[i] < median) {
                swap(nums, i, j);
                j -= 2;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int getMedian(int[] nums) {
        int low = nums[0], high = nums[0];
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            int higher = 0;
            int lower = 0;
            for (int num : nums) {
                if (num < mid)
                    lower++;
                else if (num > mid)
                    higher++;
            }
            if (higher > nums.length / 2)
                low = mid+1;
            else if (lower > nums.length / 2)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }
}

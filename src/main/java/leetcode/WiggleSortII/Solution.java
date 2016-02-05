package leetcode.WiggleSortII;

/**
 * Created by ymyue on 1/24/16.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int k = nums.length / 2;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = j - 1;
            } else
                break;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i % 2 == 0)
                i++;
            while (j % 2 == 1)
                j--;
            if (i < j)
                swap(nums, i, j);
            else
                break;
            i++;
            j--;
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = low;
        while (low < high) {
            while (low < high && nums[low] <= nums[pivot])
                low++;
            while (low < high && nums[high] > nums[pivot])
                high--;
            swap(nums, low, high);
            low++;
            high--;
        }
        swap(nums, pivot, high);
        return high;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

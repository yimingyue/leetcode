package leetcode.WiggleSortII;

/**
 * Created by ymyue on 7/31/16.
 */
public class Solution3 {
    public void wiggleSort(int[] nums) {
        int median = kthSmallest(nums, 0, nums.length-1, nums.length/2);
        int[] result = new int[nums.length];
        int i = nums.length % 2 == 0 ? nums.length -2 : nums.length - 1;
        int j = 1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] < median) {
                result[i] = nums[k];
                i -= 2;
            } else if (nums[k] > median) {
                result[j] = nums[k];
                j += 2;
            }
        }
        while (i >= 0) {
            result[i] = median;
            i -= 2;
        }
        while (j < nums.length) {
            result[j] = median;
            j += 2;
        }
        for (int k = 0; k < nums.length; k++)
            nums[k] = result[k];
    }

    private int kthSmallest(int[] arr, int low, int high, int k) {
        if (k >= 0 && k <= high - low) {
            int pos = partition(arr, low, high);
            if (pos-low == k)
                return arr[pos];
            if (pos-low > k)
                return kthSmallest(arr, low, pos-1, k);
            else
                return kthSmallest(arr, pos+1, high, k - pos + low-1);
        }
        return Integer.MAX_VALUE;
    }

    private int partition(int[] arr, int low, int high) {
        int x = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= x)
                swap(arr, i++, j);
        }
        swap(arr, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

package leetcode.WiggleSortII;

/**
 * Created by ymyue on 6/4/16.
 */
public class Solution2 {
    public void wiggleSort(int[] nums) {
        int median = findMedian(nums);
        int i = 0;
        int j = 1;
        for (i = 0; i < nums.length; i += 2) {
            if (nums[i] > median) {
                while (nums[j] > median)
                    j += 2;
                swap(nums, i, j);
            }
        }
        j = 0;
        for (i = 1; i < nums.length; i += 2) {
            if (nums[i] < median) {
                while (nums[j] < median)
                    j += 2;
                swap(nums, i, j);
            }
        }
        j = 0;
        for (i = j; i < nums.length; i += 2) {
            if (nums[i] == median) {
                swap(nums, i, j);
                j += 2;
            }
        }
        j = nums.length / 2 * 2 - 1;
        for (i = j; i >= 0; i -= 2) {
            if (nums[i] == median) {
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

    private int findMedian(int[] nums) {
        return findK(nums, 0, nums.length-1, (nums.length)/2);
    }

    private int findK(int[] nums, int start, int end, int k) {
        int p = partition(nums, start, end);
        if (p - start == k)
            return nums[p];
        else if (p - start < k)
            return findK(nums, p+1, end, k-(p-start+1));
        else
            return findK(nums, start, p-1, k);
    }

    private int partition(int[] nums, int start, int end) { // 2, 1 -
        int i = start+1;
        int j = end;
        int val = nums[start];
        while (i <= j) {
            while (i <= j && nums[i] < val)
                i++;
            while (i <= j && nums[j] > val)
                j--;
            if (j < i) {
                break;
            } else
                swap(nums, i++, j--);
        }
        swap(nums, start, j);
        return j;
    }
}

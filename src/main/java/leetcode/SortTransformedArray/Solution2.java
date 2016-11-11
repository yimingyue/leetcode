package leetcode.SortTransformedArray;

/**
 * Created by ymyue on 10/23/16.
 */
public class Solution2 {     public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int[] result = new int[nums.length];
    if (nums.length == 0)
        return result;
    if (a >= 0) {
        int i = findMin(nums, a, b , c);
        int j = i-1;
        int k = i+1;

        result[0] = f(nums[i], a, b, c);
        i = 1;
        while (i < result.length) {
            if (j < 0)
                result[i++] = f(nums[k++], a, b, c);
            else if (k == nums.length)
                result[i++] = f(nums[j--], a, b, c);
            else if (f(nums[j], a, b, c) < f(nums[k], a, b, c))
                result[i++] = f(nums[j--], a, b, c);
            else
                result[i++] =  f(nums[k++], a, b, c);
        }
    } else {
        int i = findMax(nums, a, b, c);
        int j = i-1;
        int k = i+1;
        result[result.length-1] = f(nums[i], a, b, c);
        i = result.length-2;
        while (i >= 0) {
            if (j < 0)
                result[i--] = f(nums[k++], a, b, c);
            else if (k == nums.length)
                result[i--] = f(nums[j--], a, b, c);
            else if (f(nums[j], a, b, c) > f(nums[k], a, b, c))
                result[i--] = f(nums[j--], a, b, c);
            else
                result[i--] =  f(nums[k++], a, b, c);
        }
    }
    return result;
}

    private int f(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }

    private int findMin(int[] nums, int a, int b, int c) {
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f(nums[mid], a, b, c) < f(nums[mid+1], a, b, c))
                high = mid;
            else
                low = mid+1;
        }
        return low;
    }

    private int findMax(int[] nums, int a, int b, int c) {
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f(nums[mid], a, b, c) < f(nums[mid+1], a, b, c))
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}

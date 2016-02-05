package leetcode.MaximumProductSubarray;

public class Solution2 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0;
        int maxProd = nums[0];

        while (i < nums.length) {
            int j = i;
            // skip all the 0 before subarray
            while (j < nums.length && nums[j] == 0)
                j++;
            // if has 0 in the array
            if (j > i)
                maxProd = Math.max(maxProd, 0);
            if (j == nums.length)
	        return maxProd;
            i = j;
            // find the end of the subarray
            while (j < nums.length && nums[j] != 0)
                j++;
            j--;
            if (i == j) {    // length of subarray is 1
                maxProd = Math.max(maxProd, nums[i]);
            } else {
                int x = i;
                // the product till the first negative number
                int leftProd = 1;
                while (x <= j) {
                    leftProd *= nums[x];
                    if (leftProd < 0)
                        break;
                    x++;
                }
                if (x > j) {
                    maxProd = Math.max(maxProd, leftProd);
                } else {
                    int rightProd = 1;
                    int y = j;
                    // the product after the last negative
                    while (true) {
                        rightProd *= nums[y];
                        if (rightProd < 0)
                            break;
                        y--;
                    }
                    if (x == y) {    // has only 1 negative number in the subarray
                        maxProd = Math.max(maxProd, (leftProd < rightProd ? leftProd : rightProd) / nums[x]);
                    } else {
                        int prod = leftProd * rightProd;
                        for (int z = x+1; z < y; z++)
                            prod *= nums[z];
                        if (prod > 0)           // the total product of the subarray is positive
                            maxProd = Math.max(maxProd, prod);
                        else                    // negative
                            maxProd = Math.max(maxProd, prod / (leftProd < rightProd ? rightProd : leftProd));
                    }
                }
            }
            i = j+1;
       }
       return maxProd;
    }
}

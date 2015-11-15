public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0;
        int minGap = Integer.MAX_VALUE;

        int i = 0;
        while (i < nums.length) {
            int j = i+1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return 0;
                int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    minGap = gap;
                    closestSum = sum;
                }
                if (sum < target)
                    j++;
                else
                    k--;
            }
            i++;
        }
        return closestSum;
    }
}

package leetcode.FindtheDuplicateNumber;

/**
 * Created by ymyue on 12/13/15.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = nums[i];
            while (x != i+1 && nums[x-1] != i+1) {
                x = nums[x-1];
                x = nums[x-1];
                y = nums[y-1];
                if (x == y) {
                    int count = 0;
                    for (int num : nums) {
                        if (num == x) {
                            count++;
                            if (count == 2)
                                return x;
                        }
                    }
                    y = nums[i];
                    while (x != y) {
                        x = nums[x-1];
                        y = nums[y-1];
                    }
                    return x;
                }
            }
        }
        return 0;
    }
}

package leetcode.SortColors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0 && k > i) {
                swap(nums, k, i++);
                k--;
            }
            if (nums[k] == 2 && k < j) {
                swap(nums, k, j--);
                k--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        List<String> words = new ArrayList<>();
        words.stream().map(s -> s.split("")).flatMap(Arrays::stream).collect(toList());
    }


}

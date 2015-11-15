import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rList = new ArrayList<> ();
        if (nums == null || nums.length == 0)
            return rList;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            int j = i+1;
            while (j < nums.length) {
                int k = j+1;
                int l = nums.length-1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<> ();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        rList.add(list);
                        k++;
                        while (k < l && nums[k] == nums[k-1])
                            k++;
                        l--;
                        while (k < l && nums[l] == nums[l+1])
                            l--;
                    } else if (sum < target) {
                        k++;
                    } else
                        l--;
                }
                j++;
                while (j < nums.length && nums[j] == nums[j-1])
                    j++;
            }
            i++;
            while (i < nums.length && nums[i] == nums[i-1])
                i++;
        }
	return rList;
    }
}

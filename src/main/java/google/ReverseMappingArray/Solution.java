package google.ReverseMappingArray;

/**
 * Created by ymyue on 10/7/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=199569&highlight=google
 */
public class Solution {
    public String[] reverseMapping(String[] strs, int[] nums) {
        if (strs.length != nums.length || strs.length == 0)
            return strs;
        for (int i = 0; i < strs.length; i++) {
            if (nums[i] != i) {
                String s = strs[i];
                int next = i;
                while (nums[next] != i) {
                    strs[next] = strs[nums[next]];
                    int tmp = nums[next];
                    nums[next] = next;
                    next = tmp;
                }
                strs[next] = s;
                nums[next] = next;
            }
        }
        return strs;
    }
}

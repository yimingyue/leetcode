package leetcode.RandomPickIndex;

import java.util.*;

/**
 * Created by ymyue on 9/24/16.
 */
public class Solution2 {
    Map<Integer, List<Integer>> map;
    Random random;
    public Solution2(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}

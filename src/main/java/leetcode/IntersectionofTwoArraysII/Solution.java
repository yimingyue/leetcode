package leetcode.IntersectionofTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 6/5/16.
 * HashMap solution
 * Time complexity O(m+n)
 * Space complexity O(m)
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1)
            map1.merge(num, 1, Integer::sum);
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map1.containsKey(num)) {
                if (map1.get(num) > 1)
                    map1.put(num, map1.get(num)-1);
                else
                    map1.remove(num);
                list.add(num);
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (int num : list)
            result[i++] = num;
        return result;
    }


}

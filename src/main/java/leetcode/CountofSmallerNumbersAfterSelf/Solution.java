package leetcode.CountofSmallerNumbersAfterSelf;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ymyue on 7/1/16.
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<> ();
        LinkedList<Integer> list = new LinkedList<> ();
        for (int i = nums.length-1; i >= 0; i--) {
            Integer key = map.floorKey(nums[i]-1);
            if (key == null) {
                list.addFirst(0);
                map.put(nums[i], 1);
            } else {
                int j = i+1;
                int count = map.get(key);
                while (j < nums.length && nums[j] != key) {
                    if (nums[i] > nums[j])
                        count++;
                    j++;
                }
                list.addFirst(count);
                map.put(nums[i], count+1);
            }
        }
        return list;
    }
}

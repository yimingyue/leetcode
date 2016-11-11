package leetcode.MostFrequent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/23/14
 * Time: 9:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int mostFrequent(int [] a) {
        if (a.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int val : a) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val)+1);
            } else {
                map.put(val, 1);
            }
        }

        int key = 0;
        int c = 0;
        for (int val : map.keySet()) {
            if (map.get(val) > c) {
                c = map.get(val);
                key = val;
            }
        }
        return key;
    }
}

package leetcode.InsertDeleteGetRandom;

import java.util.*;

/**
 * Created by ymyue on 9/28/16.
 * Space complexity: O(N)
 */
public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        } else
            return false;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        else {
            int index = map.get(val);
            if (index != list.size()-1) {
                int nVal = list.get(list.size()-1);
                list.set(index, nVal);
                map.put(nVal, index);
            }
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

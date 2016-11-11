package leetcode.InsertDeleteGetRandomDuplicatesallowed;

import java.util.*;

/**
 * Created by ymyue on 9/28/16.
 * Space compleity: O(N)
 */
public class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<> ();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean returnValue = false;
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<> ());
            returnValue = true;
        }
        list.add(val);
        map.get(val).add(list.size()-1);
        return returnValue;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        Set<Integer> deleteSet = map.get(val);
        int index = deleteSet.iterator().next();
        deleteSet.remove(index);
        if (index != list.size()-1) {
            int nVal = list.get(list.size()-1);
            list.set(index, nVal);
            map.get(nVal).remove(list.size()-1);
            map.get(nVal).add(index);
        }
        list.remove(list.size()-1);
        if (deleteSet.isEmpty())
            map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

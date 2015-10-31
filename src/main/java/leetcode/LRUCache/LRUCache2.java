package leetcode.LRUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 10/20/15.
 */
public class LRUCache2 {
    int capacity;
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        list.clear();
        map.clear();
    }

    public int get(int key) {
        if (map.containsKey(key))
            return map.get(key);
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            int index = list.indexOf(key);
            for (int i = index; i< list.size()-1; i++) {
                list.set(i, list.get(i+1));
            }
            list.set(list.size()-1, key);
        }
        else if (list.size() == capacity) {
            for (int i = 0; i< list.size()-1; i++) {
                list.set(i, list.get(i+1));
            }
            list.set(list.size()-1, key);
            map.put(key, value);
        } else {
            list.add(key);
            map.put(key, value);
        }
    }
}

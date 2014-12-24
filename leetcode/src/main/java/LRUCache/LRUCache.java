package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/29/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache {
    Map<Integer, Integer> frequency = new HashMap<>();
    Map<Integer, Integer> map = new HashMap<> ();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key))
            return map.get(key);
        return -1;
    }

    public void set(int key, int value) {
        if (map.size() < capacity) {
            if (!frequency.containsKey(key)) {
                frequency.put(key, 1);
            } else {
                frequency.put(key, frequency.get(key) + 1);
            }
            map.put(key, value);
        } else{
            int max = Integer.MAX_VALUE;
            int maxKey = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() < max)
                    maxKey = entry.getKey();
            }
            map.remove(maxKey);
            frequency.remove(maxKey);
            map.put(key, value);
            frequency.put(key, 1);
        }
    }
}

package leetcode.LRU;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/29/13
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache {
    public LRUCache(int capacity) {
        map = new HashMap<> ();
        a = new int[capacity];
        c = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int i = 0;
            for (; i < map.size(); i++) {
                if (a[i] == key) {
                    break;
                }
            }
            for (; i < map.size()-1; i++) {
                a[i] = a[i+1];
            }
            a[i] = key;
            return map.get(key);
        } else
            return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            int i = 0;
            for (; i < map.size(); i++) {
                if (a[i] == key) {
                    break;
                }
            }
            for (; i < map.size()-1; i++) {
                a[i] = a[i+1];
            }
            a[i] = key;
            map.put(key, value);
        } else {
            if (map.size() >= c) {
                map.remove(a[0]);
                int i = 0;
                for (; i < map.size(); i++) {
                    a[i] = a[i+1];
                }

                map.put(key, value);
                a[i] = key;
            } else {
                a[map.size()] = key;
                map.put(key, value);
            }
        }
    }

    HashMap<Integer, Integer> map = null;
    int [] a;
    int c;
}
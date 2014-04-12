package LRU;

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

    private Map<Integer, Integer> freq;
    private Map<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        freq = new HashMap<Integer, Integer> ();
        cache = new HashMap<Integer, Integer>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            freq.put(key, freq.get(key)+1);
        }
        return cache.get(key);
        /*
        if (cache.containsKey(key)) {
            Iterator iter = frequency.entrySet.iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, ArrayList<Integer>> entry = iter.next();
                ArrayList<Integer> list = entry.getValue();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    int freq = ((Integer)it.next()).intValue();
                    freq++;
                    //
                    if (freq >= capacity) {
                        it.remove();
                    } else {
                        it.set(freq);
                    }
                }
                if (list.size() == 0) {
                    iter.remove();
                    cache.remove(entry.getKey())
                }
                if(entry.)
            }
        }
        */
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            freq.put(key, freq.get(key) + 1);
            cache.put(key, value);
        } else {
            if (cache.size() == capacity) {
                Iterator it = freq.entrySet().iterator();
                int leastFreq = Integer.MAX_VALUE;
                int leastKey = 0;
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)it.next();
                    if (entry.getValue() < leastFreq) {
                        leastFreq = entry.getValue();
                        leastKey = entry.getKey();
                    }
                }
                cache.remove(leastKey);
                freq.remove(leastKey);
            }
            cache.put(key, value);
            freq.put(key, 1);
        }
    }
}

package google.MostFrequentWordInAStream;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 10/7/16.
 *
 */
public class MostFrequentWord {
    Map<String, Integer> map;
    int counter;
    String str;
    public MostFrequentWord() {
        this.map = new HashMap<>();
        this.counter = 0;
        this.str = null;
    }
    public String get() {
        return str;
    }

    public void add(String s) {
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) > counter) {
            counter = map.get(s);
            str = s;
        }
    }
}

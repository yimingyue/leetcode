package leetcode.ShortestWordDistanceII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity:
 *  - constructor: O(n)
 *  - shortest: O(m+k)
 * Space complexity: O(n)
 */
public class WordDistance {
    Map<String, List<Integer>> map = new HashMap<> ();
    int maxDist = 0;
    public WordDistance(String[] words) {
        maxDist = words.length;
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int distance = maxDist;
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                distance = Math.min(distance, list2.get(j) - list1.get(i));
                i++;
            } else {
                distance = Math.min(distance, list1.get(i) - list2.get(j));
                j++;
            }
        }
        return distance;
    }
}

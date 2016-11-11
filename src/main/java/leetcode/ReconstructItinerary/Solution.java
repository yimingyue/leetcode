package leetcode.ReconstructItinerary;

import java.util.*;

/**
 * Created by ymyue on 10/22/16.
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> degree = new HashMap<> ();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[1], new ArrayList<> ());
            map.get(ticket[1]).add(ticket[0]);
            degree.put(ticket[0], degree.getOrDefault(ticket[0], 0) - 1);
            degree.put(ticket[1], degree.getOrDefault(ticket[1], 0) + 1);
        }
        String dest = "JFK";
        for (String airport : degree.keySet()) {
            if (degree.get(airport) == 1) {
                dest = airport;
                break;
            }
        }
        List<String> result = reconstruct(map, dest);
        return result;
    }

    private List<String> reconstruct(Map<String, List<String>> map, String cur) {
        List < String > r = new ArrayList<>();
        if (map.containsKey(cur)) {
            List<List<String>> result = new ArrayList<>();
            List<String> prevs = map.get(cur);
            map.remove(cur);
            for (String prev : prevs) {
                List<String> tmp = reconstruct(map, prev);
                tmp.add(cur);
                result.add(tmp);
                Collections.sort(result, (x, y) -> {
                    int i = 0;
                    for (; i < x.size() && i < y.size(); i++) {
                        if (x.get(i).compareTo(y.get(i)) != 0)
                            return x.get(i).compareTo(y.get(i));
                    }
                    return Integer.compare(x.size(), y.size());
                });
                for (List<String> t : result) {
                    r.addAll(t);
                }
            }
        }
        return r;
    }
}

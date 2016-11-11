package leetcode.ReconstructItinerary;

import java.util.*;

/**
 * Created by ymyue on 7/31/16.
 */
public class SolutionTreeMap {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<> ();

        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0]))
                map.put(ticket[0], new PriorityQueue<String> ());
            map.get(ticket[0]).offer(ticket[1]);
        }

        Deque<String> stack = new ArrayDeque<> ();
        stack.push("JFK");
        List<String> result = new ArrayList<> ();
        while (result.size() < tickets.length + 1) {
            String next = stack.peek();
            if (!map.containsKey(next) || map.get(next).isEmpty()) {
                result.add(stack.pop());
            } else {
                stack.push(map.get(next).poll());
            }
        }
        Collections.reverse(result);
        return result;
    }
}

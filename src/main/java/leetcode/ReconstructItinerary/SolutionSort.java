package leetcode.ReconstructItinerary;

import java.util.*;

/**
 * Created by ymyue on 7/12/16.
 * https://discuss.leetcode.com/topic/36721/short-c-dfs-iterative-44ms-solution-with-explanation-no-recursive-calls-no-backtracking/3
 */
public class SolutionSort {
    public List<String> findItinerary(String[][] tickets) {
        List<String> ret = new ArrayList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).offer(ticket[1]);;
        }
        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String next = stack.peek();
            if(map.containsKey(next) && !map.get(next).isEmpty()) {
                stack.push(map.get(next).poll());
            } else {
                ret.add(next);
                stack.pop();
            }
        }
        Collections.reverse(ret);
        return ret;
    }
}

package leetcode.ReconstructItinerary;

import java.util.*;

/**
 * Created by ymyue on 7/12/16.
 */
public class SolutionBackTracing {
    private static final String JFK = "JFK";
    public List<String> findItinerary(String[][] tickets) {
        Set<String> set = new HashSet<>();
        for (String[] ticket : tickets) {
            set.add(ticket[0]);
            set.add(ticket[1]);
        }
        List<String> airports = new ArrayList<>(set);
        Collections.sort(airports);
        int size = airports.size();
        int[][] matrix = new int[size][size];
        Map<String, Integer> map = new HashMap<> ();
        for (int i = 0; i < size; i++)
            map.put(airports.get(i), i);
        for (String[] ticket : tickets) {
            int dep = map.get(ticket[0]);
            int des = map.get(ticket[1]);
            matrix[dep][des]++;
        }

        List<String> itinerary = new ArrayList<> ();
        reconstructItinerary(map.get(JFK), tickets.length+1, matrix, itinerary, airports);
        return itinerary;
    }

    private boolean reconstructItinerary(int dep, int stops, int[][] matrix, List<String> itinerary, List<String> airports) {
        itinerary.add(airports.get(dep));
        stops--;
        if (stops == 0)
            return true;
        for (int des = 0; des < matrix[dep].length; des++) {
            if (matrix[dep][des] > 0) {
                matrix[dep][des]--;
                if (reconstructItinerary(des, stops, matrix, itinerary, airports))
                    return true;
                matrix[dep][des]++;
            }
        }
        itinerary.remove(itinerary.size()-1);
        return false;
    }
}

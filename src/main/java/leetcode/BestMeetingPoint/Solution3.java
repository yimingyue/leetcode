package leetcode.BestMeetingPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ymyue on 6/5/16.
 * the best meeting point for a one dimensional starting points is the median
 */
public class Solution3 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xCoords = new ArrayList<>();
        List<Integer> yCoords = new ArrayList<> ();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    xCoords.add(i);
                    yCoords.add(j);
                }
            }
        }
        return getDist(xCoords) + getDist(yCoords);
    }

    private int getDist(List<Integer> list) {
        int sum = 0;
        Collections.sort(list);
        int i = 0;
        int j = list.size() - 1;
        while (i < j)
            sum += list.get(j--) - list.get(i++);
        return sum;
    }
}

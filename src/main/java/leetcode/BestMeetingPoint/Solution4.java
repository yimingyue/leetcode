package leetcode.BestMeetingPoint;

import leetcode.common.utils.Median;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/5/16.
 */
public class Solution4 {
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
        double median = (new Median().getMedian(list));
        for (int num : list)
            sum += Math.abs(num - median);
        return sum;
    }
}
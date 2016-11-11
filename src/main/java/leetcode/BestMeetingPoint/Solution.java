package leetcode.BestMeetingPoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 6/5/16.
 * Straightforward solution
 * Time complexity O(mnk)  - k is the number of people
 * Space complexity O(k)
 */
public class Solution {
    class Coord {
        int x;
        int y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getDist(Coord another) {
            return Math.abs(this.x - another.x) + Math.abs(this.y - another.y);
        }
    }

    public int minTotalDistance(int[][] grid) {
        List<Coord> coords = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1)
                    coords.add(new Coord(i, j));
            }
        }
        if (coords.size() < 2)
            return 0;

        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int sumDist = getSumDist(coords, new Coord(i, j));
                minDist = Math.min(minDist, sumDist);
            }
        }
        return minDist;
    }

    private int getSumDist(List<Coord> coords, Coord c) {
        int sum = 0;
        for (Coord coord: coords) {
            sum += c.getDist(coord);
        }
        return sum;
    }
}

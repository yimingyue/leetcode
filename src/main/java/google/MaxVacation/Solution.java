package google.MaxVacation;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ymyue on 10/1/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=203020 Question 1
 */
public class Solution {
    public int maxVacation(int[][] flightTime, int maxFlightTime, int[][] vacationDays, int startCity, int weeks) {
        int cities = flightTime.length;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startCity);
        int[] vacations = new int[cities];
        vacations[startCity] += vacationDays[startCity][0];
        int maxVacations = 0;
        for (int i = 1; i < weeks; i++) {
            int size = queue.size();

            int[] totalVactaions = new int[cities];
            for (int j = 0; j < size; j++) {
                int city = queue.poll();
                for (int k = 0; k < cities; k++) {
                    if (k == city || flightTime[city][k] > maxFlightTime)
                        continue;
                    totalVactaions[k] = Math.max(totalVactaions[k], vacations[city] + vacationDays[k][i]);
                    maxVacations = Math.max(maxVacations, totalVactaions[k]);
                }
            }
            for (int k = 0; k < cities; k++)
                if (totalVactaions[k] > 0)
                    queue.offer(k);
            vacations = totalVactaions;
        }
        return maxVacations;
    }
}

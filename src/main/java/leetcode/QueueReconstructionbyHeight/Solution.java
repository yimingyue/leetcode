package leetcode.QueueReconstructionbyHeight;

import java.util.Arrays;

/**
 * Created by ymyue on 9/24/16.
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int n = people.length;
        int[][] result = new int[n][2];
        boolean[] b = new boolean[n];
        for (int[] p : people) {
            int count = p[1];
            for (int i = 0; i < n; i++) {
                if (!b[i] || result[i][0] >= p[0])
                    count--;
                if (count < 0) {
                    b[i] = true;
                    result[i][0] = p[0];
                    result[i][1] = p[1];
                    break;
                }
            }
        }
        return result;
    }
}

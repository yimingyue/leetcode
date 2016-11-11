package leetcode.FrogJump;

/**
 * Created by ymyue on 9/22/16.
 */
public class Solution2 {
    public boolean canCross(int[] stones) {
        // the first dimension is the index of the stone,
        // the second one is the units that the frog can jump forward from this stone
        int n = stones.length;
        boolean[][] matrix = new boolean[n][n];
        matrix[0][1] = true;
        int target = stones[n-1];
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                // the maximum units the frog can jump is the length of the input array
                if (stones[i] - stones[j] >= n)
                    break;
                if (matrix[j][stones[i] - stones[j]]) {
                    if (target >= stones[i] + stones[i] - stones[j] - 1 && target <= stones[i] + stones[i] - stones[j] + 1)
                        return true;
                    if (stones[i] - stones[j] > 1)
                        matrix[i][stones[i] - stones[j]-1] = true;
                    matrix[i][stones[i] - stones[j]] = true;
                    if (stones[i] - stones[j] + 1 < n)
                        matrix[i][stones[i] - stones[j]+1] = true;
                }
            }
        }
        return false;
    }
}

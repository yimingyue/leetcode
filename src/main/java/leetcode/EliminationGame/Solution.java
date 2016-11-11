package leetcode.EliminationGame;

/**
 * Created by ymyue on 9/20/16.
 */

public class Solution {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n/2 - lastRemaining(n/2));
    }
}

package leetcode.GuessNumberHigherorLower;

/**
 * Created by ymyue on 7/18/16.
 */
public class GuessGame {
    protected int guess(int num) {
        if (num == 6)
            return 0;
        else if (num < 6)
            return 1;
        else
            return -1;
    }
}

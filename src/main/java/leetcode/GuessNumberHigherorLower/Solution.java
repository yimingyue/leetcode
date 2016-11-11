package leetcode.GuessNumberHigherorLower;

/**
 * Created by ymyue on 7/17/16.
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high-low)/2;
            int g = guess(mid);
            if (g == 0)
                return mid;
            else if (g < 0)
                high = mid-1;
            else
                low = mid+1;
        }
        throw new IllegalArgumentException();
    }
}

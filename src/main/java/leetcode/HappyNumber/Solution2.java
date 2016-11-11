package leetcode.HappyNumber;

/**
 * Created by ymyue on 6/7/16.
 */
public class Solution2 {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while (true) {
            fast = getNextHappy(getNextHappy(fast));
            slow = getNextHappy(slow);
            if (fast == 1)
                return true;
            if (slow == fast)
                return false;
        }
    }

    private int getNextHappy(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}

package leetcode.BullsandCows;

import java.util.Arrays;

/**
 * Created by ymyue on 6/11/16.
 * Time complexity: O(n);
 * Space complexity: O(1)
 */
public class Solution {
    public String getHint(String secret, String guess) {
        if (secret == null || guess == null)
            throw new IllegalArgumentException();
        assert(secret.length() == guess.length());
        int bull = 0;
        int cow = 0;
        int[] digits = new int[10];
        Arrays.fill(digits, 0);
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bull++;
            else {
                if (digits[secret.charAt(i) - '0']++ < 0) cow++;
                if (digits[guess.charAt(i) - '0']-- > 0) cow++;
            }
        }
        return bull + "A" + cow + "B";
    }
}

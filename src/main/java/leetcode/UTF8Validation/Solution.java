package leetcode.UTF8Validation;

/**
 * Created by ymyue on 9/17/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public boolean validUtf8(int[] data) {
        int bytes = 0;
        int i = 0;
        while (i < data.length) {
            int b = data[i] & 0xFF;
            if (bytes == 0) {
                while (bytes <= 4 && (b & (1 << (7 - bytes))) != 0)
                    bytes++;
                if (bytes == 0)
                    bytes++;
                else if (bytes > 4 || bytes == 1)
                    return false;
            } else {
                if ((b & 0xC0) != 0x80)
                    return false;
            }
            bytes--;
            i++;
        }
        return bytes == 0;
    }
}

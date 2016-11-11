package leetcode.PlusOne;

/**
 * Created by ymyue on 6/21/16.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry != 1)
                return digits;
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++)
            result[i] = 0;
        return result;
    }
}

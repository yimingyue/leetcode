package leetcode.ReverseBits;

/**
 * Created by ymyue on 10/31/15.
 */
public class Solution {
    public int reverseBits(int n) {
        int[] arr = new int[32];
        arr[0] = 1;
        for (int i = 1; i < 32; i++)
            arr[i] = 2 * arr[i-1];
        int result = 0;
        int i = 31;
        while (i >= 0) {
            result += arr[i] * (n & 1);
            n = n >> 1;
            i--;
        }
        return result;
    }
}

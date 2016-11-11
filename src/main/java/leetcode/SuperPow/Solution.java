package leetcode.SuperPow;

/**
 * Created by ymyue on 9/19/16.
 */
public class Solution {
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0)
            return 0;
        a = a % 1337;
        int[] next = new int[1337];
        int count = 0;
        int val = a;
        while (next[val] == 0) {
            next[val] = val * a % 1337;
            val = next[val];
            count++;
        }
        int m = mod(b, count);
        while (--m > 0)
            a = next[a];
        return a;
    }

    private int mod(int[] b, int c) {
        int m = 0;
        for (int i = 0; i < b.length; i++) {
            m = (m * 10 + b[i]) % c;
        }
        return m;
    }
}

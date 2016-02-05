package leetcode.StrobogrammaticNumberIII;

/**
 * Created by ymyue on 1/27/16.
 A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

 For example,
 Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

 Note:
 Because the range might be a large number, the low and high numbers are represented as string.
 */
public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int[] c = new int[high.length()];
        for (int i = 0; i < c.length; i++) {
            if (i > 1) {
                c[i] = c[i-2] * 5;
            } else if (i == 1)
                c[i] = 5;
            else
                c[i] = 3;
        }
        int[] sums = new int[high.length()];
        sums[0] = 3;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + c[i] * 4 / 5;
        }
        int highCount = getCount(high, c) + (high.length() > 1 ? sums[high.length()-2] : 0);
        int lowCount = getCount(low, c) + (low.length() > 1 ? sums[low.length()-2] : 0);
        return highCount - lowCount;
    }

    private int getCount(String s, int[] c) {
        if (s.isEmpty())
            return 0;
        if (s.length() == 1) {
            int val = Integer.parseInt(s);
            if (val < 1)
                return 1;
            if (val < 8)
                return 2;
            return 3;
        } else if (s.length() == 2) {
            int val = Integer.parseInt(s);
            if (val < 11)
                return 3;
            if (val < 69)
                return 4;
            if (val < 88)
                return 5;
            if (val < 96)
                return 6;
            return 7;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        int carry = 0;
        if (s.length() % 2 == 1) {
            i = (s.length()-1)/2;
            j = i;
            char ch = s.charAt(i);
            if (ch == '0') {
                count = 1;
            } else if (ch < '8') {
                count = 2;
            } else {
                count = 3;
            }
            if (ch == '0' || ch == '1' || ch == '8')
                carry = 0;
            else
                carry = 1;
        } else {
            i = (s.length()-1) / 2;
            j = i+1;
            int v = Integer.parseInt(s.substring(i, j+1));
            if (v < 11) {
                count = 1;
            } else if (v < 69) {
                count = 2;
            } else if (v < 88) {
                count = 3;
            } else if (v < 96) {
                count = 4;
            } else {
                count = 5;
            }
            if (v == 0 || v == 11 || v == 69 || v == 88 || v == 96)
                carry = 0;
            else
                carry = 1;
        }
        while (i > 0) {
            i--;
            j++;
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            int f = 0;
            if (ch1 == '0') {
                f = 0;
            } else if (ch1 == '1') {
                if (ch2 == '0' && carry == 0) {
                    f = 0;
                    carry = 1;
                } else {
                    f = 1;
                }
            } else if (ch1 < '6') {
                f = 1;
                carry = 1;
            } else if (ch1 == '6') {
                if (carry == 1 || ch2 == '9') {
                    f = 2;
                } else {
                    f = 1;
                    carry = 1;
                }
            } else if (ch1 < '8') {
                f = 2;
                carry = 1;
            } else if (ch1 == '8') {
                if (carry == 1 || ch2 >= '8') {
                    f = 3;
                } else {
                    f = 2;
                    carry = 1;
                }
            } else if (ch1 == '9') {
                if (carry == 1 || ch2 >= '6') {
                    f = 4;
                } else {
                    f = 3;
                    carry = 1;
                }
            }
            if (i == 0)
                f--;
            count += f * c[j-i-2];
        }
        return count;
    }
}

package main.java.leetcode.CompareVersionNumbers;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        while (true) {
            if (i >= version1.length() && j >= version2.length())
                return 0;

            int v1 = 0;
            if (i < version1.length()) {
                while (i != version1.length() && version1.charAt(i) != '.') {
                    v1 *= 10;
                    v1 += Character.getNumericValue(version1.charAt(i));
                    i++;
                }
            }
            int v2 = 0;
            if (j < version2.length()) {
                while (j != version2.length() && version2.charAt(j) != '.') {
                    v2 *= 10;
                    v2 += Character.getNumericValue(version2.charAt(j));
                    j++;
                }
            }
            if (v1 == v2) { // notice, here it might cross the boundary of i == version1.length()
                i++;
                j++;
            } else
                return v1 > v2 ? 1 : -1;
        }
    }
}

/*
Keypoints:
 1) 1.01 == 1.1
 2) 1.01 < 1.10
 3) 1.12 > 1.2
 4) ArrayBoundary check
 */

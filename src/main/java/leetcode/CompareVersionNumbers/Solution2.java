package leetcode.CompareVersionNumbers;

/**
 * Created by ymyue on 10/25/15.
 */
public class Solution2 {
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null)
            return 0;
        if (version1 == null)
            return -1;
        if (version2 == null)
            return 1;
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;
        while (true) {
            if (i == str1.length && i == str2.length)
                return 0;
            if (i == str1.length) {
                while (i < str2.length) {
                    if (Integer.parseInt(str2[i]) > 0)
                        return -1;
                    i++;
                }
                return 0;
            }
            if (i == str2.length) {
                while (i < str1.length) {
                    if (Integer.parseInt(str1[i]) > 0)
                        return 1;
                    i++;
                }
                return 0;
            }
            int num1 = Integer.parseInt(str1[i]);
            int num2 = Integer.parseInt(str2[i]);
            if (num1 > num2)
                return 1;
            else if (num1 < num2)
                return -1;
            i++;
        }
    }
}

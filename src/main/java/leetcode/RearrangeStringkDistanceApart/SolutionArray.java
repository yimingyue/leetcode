package leetcode.RearrangeStringkDistanceApart;

/**
 * Created by ymyue on 7/26/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SolutionArray {
    private static final int len = 26;
    public String rearrangeString(String str, int k) {
        int[] count = new int[len];
        int[] pos = new int[len];

        for (char ch : str.toCharArray())
            count[ch-'a']++;

        char[] res = new char[str.length()];
        for (int i = 0; i < res.length; i++) {
            int j = findMaxChar(count, pos, i, k);
            if (j == -1)
                return "";
            res[i] = (char)('a' + j);
        }
        return String.valueOf(res);
    }

    private int findMaxChar(int[] count, int[] pos, int index, int k) {
        int maxPos = -1;
        int maxCount = 0;
        for (int i = 0; i < len; i++) {
            if (count[i] > maxCount && pos[i] <= index) {
                maxPos = i;
                maxCount = count[i];
            }
        }
        if (maxPos != -1) {
            count[maxPos]--;
            pos[maxPos] = index + k;
        }
        return maxPos;
    }
}

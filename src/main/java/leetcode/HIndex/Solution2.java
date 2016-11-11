package leetcode.HIndex;

/**
 * Created by ymyue on 6/4/16.
 * Using auxiliary array
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class Solution2 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int[] index = new int[citations.length+1];
        for (int citation : citations) {
            int tmp = citation > citations.length ? index[citations.length]++ : index[citation]++;
        }
        int sum = 0;
        for (int i = index.length-1; i >= 0; i--) {
            sum += index[i];
            if (sum >= i)
                return i;
        }
        return 0;
    }
}

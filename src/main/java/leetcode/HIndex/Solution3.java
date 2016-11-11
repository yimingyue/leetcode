package leetcode.HIndex;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution3 {
    public int hIndex(int[] citations) {
        int[] h = new int[citations.length+1];
        for (int citation : citations) {
            int index = citation >= h.length ? h.length-1 : citation;
            h[index]++;
        }
        for (int i = h.length-1; i >= 0; i--) {
            h[i] += i == h.length-1 ? 0 : h[i+1];
            if (h[i] >= i)
                return i;
        }
        return -1;
    }
}

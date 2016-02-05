package interview.amazon.test2;

/**
 * Created by ymyue on 1/11/16.
 */
public class Solution {
    static int[] mergeArrays(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        while (i+j < res.length) {
            if (i == a.length) {
                res[i+j] = b[j];
                j++;
            } else if (j == b.length || a[i] < b[j]) {
                res[i+j] = a[i];
                i++;
            } else {
                res[i+j] = b[j];
                j++;
            }
        }
        return res;
    }
}

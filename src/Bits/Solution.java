package Bits;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/25/14
 * Time: 9:22 AM
 * To change this template use File | Settings | File Templates.
 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 7
        if (A.length == 0)
            return 0;

        int [] B = new int [2*A.length];

        for (int i = 0; i < A.length; i++) {
            B[2*i] = A[i];
            B[2*i+1] = A[i]+1;
        }

        int remain = 0;
        int count = 0;
        for (int i = 0; i < B.length-1; i++) {
            if (B[i] != B[i+1]) {
                if (remain == 0)
                    count++;
            } else {
                if (remain == 1) {
                    count++;
                    remain = 0;
                }
                else
                    remain = 1;
                i++;
            }
        }
        count++;
        return count;
    }
}

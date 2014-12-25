package leetcode.FarFromAvg;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/23/14
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 7
            if (A.length == 0)
                return -1;

            int remain = 0;
            int avg = 0;
            int N = A.length;
            for (int i = 0; i < N; i++) {
                int val = A[i] / N;
                avg += val;
                int rem = A[i] % N;
                remain += rem;
                if (remain >= N) {
                    remain -= N;
                    avg += 1;
                } else if (remain <= -N) {
                    remain += N;
                    avg -= 1;
                }
            }

            int a = avg + Math.round((float)remain / N);

            int maxDist = -1;
            int index = -1;
            for (int i = 0; i < A.length; i++) {
                int dist = Math.abs(A[i]-avg);
                if (dist > maxDist) {
                    maxDist = dist;
                    index = i;
                }
            }
            return index;
        }
    }

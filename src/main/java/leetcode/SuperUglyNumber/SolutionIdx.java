package leetcode.SuperUglyNumber;

/**
 * Created by ymyue on 7/20/16.
 * https://discuss.leetcode.com/topic/34841/java-three-methods-23ms-36-ms-58ms-with-heap-performance-explained
 * Time complexity: O(nk)
 * Space complexity: O(n)
 */
public class SolutionIdx {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int k = primes.length;
        int[] idx = new int[k];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++)
                min = Math.min(min, primes[j] * ugly[idx[j]]);

            ugly[i] = min;
            for (int j = 0; j < k; j++) {
                if (primes[j] * ugly[idx[j]] == min)
                    idx[j]++;
            }
        }
        return ugly[n-1];
    }
}

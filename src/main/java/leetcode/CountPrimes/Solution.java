package leetcode.CountPrimes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 11/1/15.
 */
public class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int count = 0;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < n; i++) {
            boolean isPrime = true;
            for (int prime: primes) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
                if (i < prime * prime)
                    break;
            }
            if (isPrime)
                primes.add(i);

        }
        return primes.size();
    }
}

package leetcode.MaximumGap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;

/**
 * Created by ymyue on 1/18/16.
 * Pigeon hole theory
 */
public class Solution {
    public int maximumGap(int[] nums) {         // 2, 2, 3
        if (nums.length < 2)
            return 0;
        IntSummaryStatistics summary = Arrays.stream(nums).summaryStatistics();
        int min = summary.getMin();
        int max = summary.getMax();

        int buckets = nums.length;        // 2
        HashMap<Integer, Integer> highest = new HashMap<> ();                   // 0 - 2, 2 - 7
        HashMap<Integer, Integer> lowest = new HashMap<> ();                    // 0 - 2, 2 - 7
        for (int num : nums) {
            int bucket = getBucket(num, min, max, buckets);
            highest.merge(bucket, num, Math::max);
            lowest.merge(bucket, num, Math::min);
        }
        int last = highest.get(0);                  // 2
        int maxGap = 0;
        for (int i =1; i <= buckets; i++) {
            if (lowest.containsKey(i)) {
                maxGap = Math.max(maxGap, lowest.get(i) - last);            // 7 - 2
                last = highest.get(i);
            }
        }
        return maxGap;                          // 5
    }

    private int getBucket(int num, int min, int max, int buckets) {
        return (num - min) / ((max - min) / buckets + 1);
    }
}

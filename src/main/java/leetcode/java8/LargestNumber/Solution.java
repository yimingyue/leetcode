package leetcode.java8.LargestNumber;

import java.util.Arrays;

/**
 * Created by ymyue on 5/28/16.
 * Radix based on Java 8
 * Code from https://leetcode.com/discuss/21550/my-3-lines-code-in-java-and-python
 */
public class Solution {
    public String largestNumer(int[] nums) {
        String[] array = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }
}
/**
 * Time complexity: O(nlgn) - sort
 * Space complexity O(n) - new array
 */
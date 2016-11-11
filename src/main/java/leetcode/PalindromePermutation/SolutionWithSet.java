package leetcode.PalindromePermutation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymyue on 7/18/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SolutionWithSet {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (!set.add(ch))
                set.remove(ch);
        }
        return set.size() < 2;
    }
}

package leetcode.java8.ValidAnagram;

import java.util.stream.Collectors;

/**
 * Created by ymyue on 5/31/16.
 */
public class Solution3 {
    public boolean isAnagram(String s, String t) {
        return s.chars().mapToObj(i -> (char)i).sorted().collect(Collectors.toList()).equals(t.chars().mapToObj(i -> (char)i).sorted().collect(Collectors.toList()));
    }
}


/*
 * Time complexity: O(nlgn)
 * Space complexity: O(n)
 */
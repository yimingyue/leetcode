package leetcode.WordBreak;

import java.util.Set;

/**
 * Created by ymyue on 7/9/16.
 * Time complexity: O(n^2) - n is the length of s
 * Space complexity: O(n)
 */
public class SolutionDP {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] breakable = new boolean[s.length()+1];
        breakable[0] = true;
        for (int i = 1; i < s.length(); i++) {
            if (breakable[i]) {
                for (int j = i+1; j <= s.length(); j++) {
                    if (!breakable[j] && wordDict.contains(s.substring(i, j))) {
                        breakable[j] = true;
                    }
                }
            }
            if (breakable[s.length()])
                return true;
        }
        return false;
    }
}

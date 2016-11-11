package leetcode.PalindromePairs;

import java.util.*;

/**
 * Created by ymyue on 6/11/16.
 * Time complexity: O(n*k^2)
 * Space complexity: O(n)
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<> ();
        Map<String, Integer> map = new HashMap<> ();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);

        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(rev) && map.get(rev) != i)
                result.add(Arrays.asList(i, map.get(rev)));

            int j = 1;
            while (j <= words[i].length()) {
                String sub = rev.substring(j);
                if (map.containsKey(sub) && isPalinDrome(words[i], words[i].length()-j, words[i].length()-1))
                    result.add(Arrays.asList(i, map.get(sub)));
                j++;
            }

            j = 1;
            while (j <= words[i].length()) {
                String sub = rev.substring(0, rev.length()-j);
                if (map.containsKey(sub) && isPalinDrome(words[i], 0, j-1))
                    result.add(Arrays.asList(map.get(sub), i));
                j++;
            }
        }
        return result;
    }

    private boolean isPalinDrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}

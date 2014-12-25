package main.java.leetcode.IsPalindrome;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/21/14
 * Time: 9:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {

        public int solution(String S) {
            // write your code in Java SE
            if (S == null || S.isEmpty())
                return 1;

            Map<Character, Integer> map = new HashMap<Character, Integer> ();

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)+1);
                } else {
                    map.put(c, 1);
                }
            }

            int count = 0;
            for (char key : map.keySet()) {
                if ((map.get(key) % 2) == 1) {
                    count++;
                    if (count == 2)
                        return 0;
                }
            }
            return 1;
        }
    }


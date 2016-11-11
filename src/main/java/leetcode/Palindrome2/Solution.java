package leetcode.Palindrome2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/17/14
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    /*
    public int minCut(String s) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        for (int i = 1; i <= s.length(); i++) {
            int cuts = s.length();
            for (int j = 0; j < i; j++) {
                if (map.containsKey(j)) {
                    if (isPalindrome(s.substring(j, i))) {
                        if (cuts > map.get(j)+1) {
                            cuts = map.get(j)+1;
                        }
                    }
                }
            }
            Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Integer, Integer> entry = iter.next();
                if (entry.getValue() >= cuts)
                iter.remove();
            }
            map.put(i, cuts);
        }
        return map.get(s.length()) - 1;
    }
    */

    public int minCut(String s) {
        int l = s.length();
        int [][] a = new int[l][l];

        for (int i = 0; i < s.length(); i++) {
            a[i][i] = 0;
            char c = s.charAt(i);
            for (int j = i-1; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (j+1 > i-1)
                        a[j][i] = 0;
                    else if (a[j+1][i-1] == 0)
                        a[j][i] = 0;
                    else
                        a[j][i] = 1;
                } else
                    a[j][i] = 1;
            }
        }

        int [] cuts = new int[s.length()];
        cuts[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            int cut = s.length();
            for (int j = i; j >= 0 ;j--) {
                if (a[j][i] == 0) {
                    if (j == 0)
                        cut = 0;
                    else if (cut > cuts[j-1] + 1)
                        cut = cuts[j-1] + 1;
                }
            }
            cuts[i] = cut;
        }
        return cuts[s.length()-1];
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}

package MinimalWindowSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/16/14
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String minWindow(String S, String T) {
        int m = T.length();
        Map<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>> ();
        for (int i = 0; i < m; i++) {
            char c = T.charAt(i);
            if (!map.containsKey(c)) {
                ArrayList<Integer> list = new ArrayList<Integer> ();
                list.add(-1);
                map.put(c, list);
            } else {
                ArrayList<Integer> list = map.get(c);
                list.add(-1);
            }
        }
        boolean [] f = new boolean[S.length()];
        for (int i = 0; i < S.length(); i++)
            f[i] = false;
        int count = 0;
        int left = -1;
        int window = S.length() + 1;
        int wleft = -1;
        int wright = -1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                if (left == -1)
                    left = i;
                f[i] = true;
                ArrayList<Integer> list = map.get(c);
                int j = 0;
                for (; j < list.size(); j++) {
                    if (list.get(j) == -1) {
                        list.set(j, i);
                        count++;
                        break;
                    }
                }
                if (j == list.size()) {
                    int pre = list.remove(0);
                    list.add(i);
                    f[pre] = false;
                    if (pre == left) {
                        while (!f[left])
                            left++;
                    }
                }
                if (count >= m) {
                    int size = i - left + 1;
                    if (size < window) {
                        window = size;
                        wleft = left;
                        wright = i+1;
                    }
                }
            }
        }
        if (window <= S.length()) {
            return S.substring(wleft, wright);
        } else
            return "";
    }
}
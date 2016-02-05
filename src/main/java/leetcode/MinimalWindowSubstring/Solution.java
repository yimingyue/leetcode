package leetcode.MinimalWindowSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
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
    */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty())
            return "";
        int[] arr = new int[256];
        Set<Character> set = new HashSet<> ();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            arr[(int)ch] = arr[(int)ch] + 1;
            set.add(ch);
        }

        int[] cnt = new int[256];
        int i = 0;
        char ch = 'a';
        while (i < s.length()) {
            ch = s.charAt(i);
            cnt[(int)ch]++;
            if (cnt[(int)ch] == arr[(int)ch]) {
                set.remove(ch);
                if (set.isEmpty())
                    break;
            }
            i++;
        }
        if (i == s.length())
            return "";
        cnt[ch] = cnt[ch] - 1;
        int j = 0;
        int start = 0;
        int end = 0;
        int minLen = s.length()+1;
        while (i < s.length()) {
            ch = s.charAt(i);
            cnt[(int)ch] = cnt[(int)ch] + 1;
            while (j <= i) {
                ch = s.charAt(j);
                if (cnt[(int)ch] == arr[(int)ch]) {
                    if (i - j + 1 < minLen) {
                        start = j;
                        end = i+1;
                        minLen = i-j+1;
                    }
                    break;
                } else {
                    cnt[(int)ch] = cnt[(int)ch]-1;
                }
                j++;
            }
            i++;
        }
        return s.substring(start, end);
    }
}
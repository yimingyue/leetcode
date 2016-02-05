package leetcode.RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ymyue on 11/28/15.
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> rList = new ArrayList<> ();
        if (isValid(s)) {
            rList.add(s);
            return rList;
        }
        Set<String> set = new HashSet<> ();
        set.add(s);
        boolean valid = false;
        while (!set.isEmpty()) {
            Set<String> nSet = new HashSet<> ();
            Set<String> validSet = new HashSet<> ();
            for (String str : set) {
                for (int i = 0; i < str.length(); i++) {
                    String nStr = str.substring(0, i) + str.substring(i+1, str.length());
                    nSet.add(nStr);
                    if (isValid(nStr))
                        validSet.add(nStr);
                }
            }
            if (validSet.isEmpty()) {
                set = nSet;
            } else {
                rList.addAll(validSet);
                break;
            }
        }
        return rList;
    }

    private boolean isValid(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else if (s.charAt(i) == ')')
                right++;
            if (right > left)
                return false;
        }
        return left == right;
    }
}

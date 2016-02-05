package leetcode.RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 1/1/16.
 */
public class Solution2 {
    public List<String> restoreIpAddresses(String s) {
        List<String> rList = new ArrayList<> ();
        build(rList, s, 0, "", 4);
        return rList;
    }

    private void build(List<String> rList, String s, int i, String str, int k) {
        if (s.length() - i > 3 * k || s.length() - i < k)
            return;
        for (int j = i+1; j < i+4 && j <= s.length(); j++) {
            if (s.length() - j < k-1)
                break;
            else if (s.length() - j > 3 * (k-1))
                continue;
            String cur = s.substring(i, j);
            if (!isValid(cur))
                break;
            cur = str + cur;
            if (k == 1)
                rList.add(cur);
            else
                build(rList, s, j, cur + ".", k-1);
        }
    }

    boolean isValid(String str) {
        if (str.length() > 1 && str.charAt(0) == '0')
            return false;
        if (Integer.parseInt(str) > 255)
            return false;
        return true;
    }
}

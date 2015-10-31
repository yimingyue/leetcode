package leetcode.RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 8/23/15.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        return buildList(list, s, 4);
    }

    private List<String> buildList(List<String> list, String s, int n) {
        List<String> rList = new ArrayList<> ();
        if (s.length() > n*3 || s.length() < n*1)
            return rList;
        if (n == 1) {
            if (Integer.parseInt(s) > 255)
                return rList;
            else if (s.charAt(0) == '0' && s.length() > 1)
                return rList;
            else {
                for (String string : list) {
                    rList.add(string + "." + s);
                }
                return rList;
            }
        }
        int i = 1;
        while (s.length()-i > (n-1) * 3)
            i++;
        while ((s.length()-i >= (n-1) * 1) && i < 4) {
            if (i > 1 && s.charAt(0) == '0')
                break;
            String str = s.substring(0, i);
            if (Integer.parseInt(str) <= 255) {
                List<String> nList = new ArrayList<> ();
                if (!list.isEmpty()) {
                    for (String string : list) {
                        nList.add(string + "." + str);
                    }
                } else
                    nList.add(str);
                rList.addAll(buildList(nList, s.substring(i), n-1));
            }
            i++;
        }
        return rList;
    }
}

/*
  mistakes made:
  1. missed i++ in while loop
  2. wrong interface design for the recursive function, used void instead of List<String>
  3. ip address should not be 01 or 001 format
 */
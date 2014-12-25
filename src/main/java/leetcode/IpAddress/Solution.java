package leetcode.IpAddress;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 3/10/14
 * Time: 10:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> list = new ArrayList<String> ();
        if (s == null || s.isEmpty() || s.length() > 12)
            return list;
        for (int i = 1; i < s.length() && i < 4; i++) {
            int val1 = Integer.parseInt(s.substring(0, i));
            if (val1 > 255 || (s.substring(0, i).length() > 1 && s.substring(0, i).startsWith("0")))
                break;
            for (int j = i+1; j < s.length() && j < 7; j++) {
                int val2 = Integer.parseInt(s.substring(i, j));
                if (val2 > 255 || (s.substring(i, j).length() > 1 && s.substring(i, j).startsWith("0")))
                    break;
                for (int k = j+1; k < s.length() && k < 10; k++) {
                    int val3 = Integer.parseInt(s.substring(j, k));
                    if (val3 > 255 || (s.substring(j, k).length() > 1 && s.substring(j, k).startsWith("0")))
                        break;
                    int val4 = Integer.parseInt(s.substring(k));
                    if (val4 > 255)
                        break;
                    if (s.substring(k).length() > 1 && s.substring(k).startsWith("0"))
                        continue;
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.substring(0, i));
                    sb.append(".");
                    sb.append(s.substring(i, j));
                    sb.append(".");
                    sb.append(s.substring(j, k));
                    sb.append(".");
                    sb.append(s.substring(k));
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }
}
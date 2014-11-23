package Anagrams;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/21/14
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> rList = new ArrayList<String> ();
        if (strs.length == 0)
            return rList;
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>> ();
        for (int i = 0; i < strs.length; i++) {
            String s = "";
            char [] c = strs[i].toCharArray();
            Arrays.sort(c);
            s = String.valueOf(c);
            if (!map.containsKey(s)) {
                ArrayList<String> list = new ArrayList<String> ();
                list.add(strs[i]);
                map.put(s, list);
            } else {
                ArrayList<String> list = map.get(s);
                list.add(strs[i]);
            }
        }
        for (String s : map.keySet()) {
            ArrayList<String> list = map.get(s);
            if (list.size() > 1)
                rList.addAll(list);
        }
        return rList;
    }
}
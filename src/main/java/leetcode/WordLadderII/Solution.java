package leetcode.WordLadderII;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/20/14
 * Time: 8:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>> ();
        dict.add(end);
        dict.remove(start);

//        Map<String, Integer> strMap = new HashMap<String, Integer> ();
//        ArrayList<String> dictList = new ArrayList<String> ();
//        int i = 0;
//        strMap.put(start, i++);
//        dictList.add(start);
//        for (String dictStr : dict) {
//            strMap.put(dictStr, i++);
//            dictList.add(dictStr);
//        }
        // map maintains the mapping of the string and all shortest path to this string
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Map<String, Set<String>> bigMap = new HashMap<String, Set<String>> ();

        // initialize the map
        Set<String> sList = new HashSet<String> ();
        map.put(start, sList);

        // BFS
        while (!map.isEmpty()) {
            bigMap.putAll(map);
            map = convert(dict, map);

            if (map.containsKey(end)) {
                bigMap.put(end, map.get(end));
                ArrayList<ArrayList<String>> rList = new ArrayList<ArrayList<String>> ();
                ArrayList<String> aList = new ArrayList<String>();
                aList.add(end);
                getLadders(rList, bigMap, start, end, aList);
                return rList;
            } else
                bigMap.putAll(map);
        }

        return new ArrayList<ArrayList<String>> ();
    }

    private Map<String, Set<String>> convert(Set<String> dict, Map<String, Set<String>> map) {
        // Set<Line> m = new HashSet<Line> ();
        Map<String, Set<String>> tMap = new HashMap<String, Set<String>> ();
        for (String s : map.keySet()) {
            for (int i = 0; i < s.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == s.charAt(i)) continue;
                    String r = s.substring(0, i) + c + s.substring(i+1);
                    if (dict.contains(r)) {
                        Set<String> tmpList = null;
                        if (tMap.containsKey(r))
                            tmpList = tMap.get(r);
                        else {
                            tmpList = new HashSet<String> ();
                            tMap.put(r, tmpList);
                        }
                        tmpList.add(s);
                    }
                }
            }
        }
        dict.removeAll(tMap.keySet());
        return tMap;
    }

    private void getLadders(ArrayList<ArrayList<String>> rList, Map<String, Set<String>> bigMap, String start, String cur, ArrayList<String> curList) {
        if (cur.equals(start)) {
            rList.add(new ArrayList<String>(curList));
            return;
        }

        for (String str : bigMap.get(cur)) {
            curList.add(0, str);
            getLadders(rList, bigMap, start, str, curList);
            curList.remove(0);
        }
    }
}
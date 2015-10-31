package leetcode.WordLadderII;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/6/14
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
            Map<String, List<String>> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            Set<String> fullSet = new HashSet<> ();
            List<String> list = new ArrayList<> ();
            List<List<String>> rList = new ArrayList<> ();

            if (start.equals(end)) {
                list.add(start);
                list.add(end);
                rList.add(list);
                return rList;
            }
            set.add(start);
            fullSet.add(start);
            while(!set.isEmpty()) {
                Set<String> newSet = new HashSet<> ();
                for (String s : set) {
                    newSet.addAll(generateStrs(s, dict, fullSet, map));
                }
                if (newSet.contains(end)) {
                    buildList(rList, map, list, end);
                    return rList;
                }
                set = newSet;
                fullSet.addAll(set);
            }
            return rList;
        }

        private Set<String> generateStrs(String s, Set<String> dict, Set<String> fullSet, Map<String, List<String>> map) {
            Set<String> set = new HashSet<> ();
            for (int i = 0; i < s.length(); i++) {
                char[] array = s.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    array[i] = c;
                    String str = new String(array);
                    if (dict.contains(str) && !fullSet.contains(str)) {
                        set.add(str);
                        if (map.containsKey(str)) {
                            List<String> list = map.get(str);
                            list.add(s);
                        }
                        else {
                            List<String> list = new ArrayList<String> ();
                            list.add(s);
                            map.put(str, list);
                        }
                    }
                }
            }
            return set;
        }

        private void buildList(List<List<String>> rList, Map<String, List<String>> map, List<String> list, String s) {
            List<String> nList = new ArrayList<> (list);
            nList.add(s);
            if (!map.containsKey(s)) {
                rList.add(nList);
                return;
            }

            List<String> sList = map.get(s);
            for (String str : sList) {
                buildList(rList, map, nList, str);
            }
        }
}

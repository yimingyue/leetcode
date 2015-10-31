package leetcode.WordLadderII;

import java.util.*;

/**
 * Created by ymyue on 10/11/15.
 */
public class Solution3 {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Set<String> set = new HashSet<> ();
        set.add(beginWord);
        Map<String, List<String>> map = new HashMap<> ();
        boolean reached = false;
        wordList.remove(beginWord);
        wordList.remove(endWord);
        while (!set.isEmpty() && !reached) {
            Set<String> nSet = new HashSet<> ();
            for (String str : set) {
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == c)
                            continue;
                        String nStr = str.substring(0, i) + ch + str.substring(i+1);
                        if (nStr.equals(endWord)) {
                            reached = true;
                            if (map.containsKey(str)) {
                                map.get(str).add(nStr);
                            } else {
                                List<String> list = new ArrayList<> ();
                                list.add(nStr);
                                map.put(str, list);
                                break;
                            }
                        } else if (wordList.contains(nStr)) {
                            nSet.add(nStr);
                            if (map.containsKey(str)) {
                                map.get(str).add(nStr);
                            } else {
                                List<String> list = new ArrayList<> ();
                                list.add(nStr);
                                map.put(str, list);
                            }
                        }
                    }
                }
            }
            wordList.removeAll(nSet);
            set = nSet;
        }
        List<List<String>> rList = new ArrayList<> ();
        if (!reached)
            return rList;
        else
            reached = false;

        List<String> list = new ArrayList<> ();
        list.add(beginWord);
        rList.add(list);
        while (!reached) {
            List<List<String>> nRList = new ArrayList<> ();
            for (List<String> iList : rList) {
                String last = iList.get(iList.size()-1);
                if (map.containsKey(last)) {
                    List<String> mList = map.get(last);
                    for (String str : mList) {
                        List<String> nList = new ArrayList<>(iList);
                        nList.add(str);
                        if (str.equals(endWord))
                            reached = true;
                        nRList.add(nList);
                    }
                }
            }
            rList = nRList;
        }
        Iterator<List<String>> iter = rList.iterator();
        while (iter.hasNext()) {
            List<String> iList = iter.next();
            if (!iList.get(iList.size()-1).equals(endWord))
                iter.remove();
        }
        return rList;
    }
}

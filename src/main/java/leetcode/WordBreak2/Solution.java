package leetcode.WordBreak2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/8/14
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
*/
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> list = new ArrayList<String>();
        if (s == null)
            return list;
        if (dict == null || dict.size() == 0)
            return list;
        if (dp0(s, dict)) {
            for (String str: dp(s, dict))
                list.add(str);
        }
        return list;
    }

    private boolean dp0(String s, Set<String> dict) {
        Set<String> set = new HashSet<String>();
        set.add("");
        Set<Integer> processedSet = new HashSet<Integer>();
        while (!set.isEmpty()) {
            Iterator<String> iter = set.iterator();
            Set<String> tmpSet = new HashSet<String>();
            while (iter.hasNext()) {
                String prefix = iter.next();
                if (!processedSet.contains(prefix.length())) {
                    Iterator<String> it = dict.iterator();
                    while (it.hasNext()) {
                        String str = it.next();
                        String matchStr = prefix + str;
                        if (s.startsWith(matchStr)) {
                            if (s.equals(matchStr))
                                return true;
                            tmpSet.add(matchStr);
                        }
                    }
                    processedSet.add(prefix.length());
                }
                iter.remove();
            }
            set.addAll(tmpSet);
        }
        return false;
    }


    private Set<String> dp(String s, Set<String> dict) {
        Set<String> set = new HashSet<String>();
        set.add("");
        Map<Integer, Set<Integer>> iMap = new HashMap<Integer, Set<Integer>>();

        Set<String> rList = new HashSet<String>();
        while (!set.isEmpty()) {
            Iterator<String> iter = set.iterator();
            Set<String> tmpSet = new HashSet<String>();

            while (iter.hasNext()) {
                String prefix = iter.next();
                Iterator<String> it = dict.iterator();
                while (it.hasNext()) {
                    String str = it.next();
                    String matchStr = prefix + str;
                    if (s.startsWith(matchStr)) {
                        if (s.equals(matchStr)) {
                            ArrayList<String> sList = getString(s, iMap, prefix.length());
                            if (sList != null) {
                                for (String st : sList) {
                                    if (st.isEmpty())
                                        rList.add(str);
                                    else
                                        rList.add(st + " " + str);
                                }

                            }
                        } else {
                            int iLength = prefix.length() + str.length();
                            Set<Integer> iSet = iMap.get(iLength);
                            if (iSet == null) {
                                iSet = new HashSet<Integer>();
                                iSet.add(prefix.length());
                            } else
                                iSet.add(prefix.length());
                            iMap.put(iLength, iSet);
                            tmpSet.add(matchStr);
                        }
                    }
                }
                iter.remove();
            }
            set.addAll(tmpSet);
        }
        return rList;
    }


    private ArrayList<String> getString(String s, Map<Integer, Set<Integer>> iMap, int index) {
        ArrayList<String> rList = new ArrayList<String>();
        if (index == 0) {
            rList.add("");
            return rList;
        }

        Set<Integer> set = iMap.get(index);

        for (int j : set) {
            ArrayList<String> sList = getString(s, iMap, j);
            if (sList != null) {
                for (String str : sList) {
                    if (str.isEmpty())
                        rList.add(s.substring(j, index));
                    else
                        rList.add(str + " " + s.substring(j, index));
                }

            }
        }
        return rList;
    }
}
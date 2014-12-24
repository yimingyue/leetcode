package WordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/8/14
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null)
            return false;
        if (dict == null || dict.size() == 0)
            return false;

        System.out.println( dp(s, dict));
        return false;
    }

    private boolean dp(String s, Set<String> dict) {
        Set<String> set = new HashSet<String> ();
        set.add("");
        while (!set.isEmpty()) {
            Iterator<String> iter = set.iterator();
            Set<String> tmpSet = new HashSet<String> ();
            while (iter.hasNext()) {
                String prefix = iter.next();
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
                iter.remove();
            }
            set.addAll(tmpSet);
        }
        return false;
    }
}
package SubstringConcatenation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/6/14
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> list = new ArrayList<Integer> ();
        if (L.length == 0) {
            list.add(0);
            return list;
        }
        int m = L.length;
        int n = L[0].length();
        int [] a = new int[S.length()-n+1];
        for (int i = 0; i < a.length; i++)
            a[i] = -1;
        for (int i = 0; i <= S.length()-n; i++) {
            String str = S.substring(i, i+n);
            for (int j = 0; j < L.length; j++) {
                if (str.equals(L[j])) {
                    a[i] = j;
                    break;
                }
            }
        }

        for (int i = 0; i <= S.length()-m*n; i++) {
            Set<Integer> set = new HashSet<Integer>();
            int j = 0;
            for (; j < m; j++) {
                if (a[i+j*n] == -1)
                    break;
                if (set.contains(a[i+j*n]))
                    break;
                set.add(a[i+j*n]);
            }
            if (j == m)
                list.add(i);
        }
        return list;
    }
}
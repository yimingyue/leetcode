package leetcode.PalindromePartitioning;
import java.util.*;

/**
 * Created by ymyue on 10/18/15.
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> rList = new ArrayList<> ();
        if (s == null || s.isEmpty())
            return rList;
        int n = s.length() + 1;
        boolean [][] arr = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i + j == n)
                    break;
                if (j < 2)
                    arr[i][i+j] = true;
                else if ((s.charAt(i) == s.charAt(i+j-1) && arr[i+1][i+j-1])) {
                    arr[i][i+j] = true;
                }
            }
        }
        buildList(rList, new ArrayList<String>(), 0, n-1, arr, s);
        return rList;
    }

    private void buildList(List<List<String>> rList, List<String> list, int index, int n, boolean[][] arr, String s) {
        if (index == n) {
            rList.add(list);
            return;
        }
        for (int i = index + 1; i < arr[index].length; i++) {
            if (arr[index][i]) {
                List<String> nList = new ArrayList<String> (list);
                nList.add(s.substring(index, i));
                buildList(rList, nList, i, n, arr, s);
            }
        }
    }
}

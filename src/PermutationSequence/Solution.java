package PermutationSequence;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/19/14
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        int [] a = new int [10];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i <= 9; i++)
            a[i] = (i-1) * a[i-1];
        ArrayList<Integer> list = new ArrayList<Integer> ();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        return getPermu(list, k-1, n, a);
    }

    private String getPermu(ArrayList<Integer> list, int k, int n, int [] a) {
        if (n == 0)
            return "";
        int base = a[n];
        int offset = k / base;
        int d = list.get(offset);
        list.remove(offset);
        k -= base * offset;
        n--;
        return String.valueOf(d).concat(getPermu(list, k, n, a));
    }
}

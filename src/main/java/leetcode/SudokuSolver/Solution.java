package leetcode.SudokuSolver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/7/14
 * Time: 5:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rMap = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Set<Integer>> cMap = new HashMap<Integer, Set<Integer>> ();
        Map<Integer, Set<Integer>> bMap = new HashMap<Integer, Set<Integer>> ();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                int val = board[i][j] - '0';
                put(i, j, val, rMap, cMap, bMap);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    solve(board, i, j, rMap, cMap, bMap);
                    return;
                }
            }
        }
    }

    private boolean solve(char [][] board, int i, int j,
                          Map<Integer, Set<Integer>> rMap, Map<Integer, Set<Integer>> cMap, Map<Integer, Set<Integer>> bMap) {
        for (int k = 1; k <= 9; k++) {
            if (!check(i, j, k, rMap, cMap, bMap))
                continue;
            board[i][j] = (char)('0' + k);
            put(i, j, k, rMap, cMap, bMap);
            int [] a = getNext(board);
            if (a[0] == -1 && a[1] == -1)
                return true;
            if (solve(board, a[0], a[1], rMap, cMap, bMap))
                return true;
            recover(i, j, k, rMap, cMap, bMap);
            board[i][j] = '.';
        }
        return false;
    }

    private int [] getNext(char [][] board) {
        int [] a = new int[2];
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (board[m][n] == '.') {
                    a[0] = m;
                    a[1] = n;
                    return a;
                }
            }
        }
        a[0] = -1;
        a[1] = -1;
        return a;
    }

    private boolean check(int i, int j, int k,
                          Map<Integer, Set<Integer>> rMap, Map<Integer, Set<Integer>> cMap, Map<Integer, Set<Integer>> bMap) {
        if (rMap.containsKey(k) && rMap.get(k).contains(i))
            return false;
        if (cMap.containsKey(k) && cMap.get(k).contains(j))
            return false;
        if (bMap.containsKey(k) && bMap.get(k).contains(i/3*3+j/3))
            return false;
        return true;
    }

    private void put(int i, int j, int val,
                     Map<Integer, Set<Integer>> rMap, Map<Integer, Set<Integer>> cMap, Map<Integer, Set<Integer>> bMap) {
        if (rMap.containsKey(val)) {
            Set set = rMap.get(val);
            set.add(i);
        } else {
            Set set = new HashSet<Integer>();
            set.add(i);
            rMap.put(val, set);
        }

        if (cMap.containsKey(val)) {
            Set set = cMap.get(val);
            set.add(j);
        } else {
            Set set = new HashSet<Integer> ();
            set.add(j);
            cMap.put(val, set);
        }

        int b = (i/3)*3 + j/3;
        if (bMap.containsKey(val)) {
            Set set = bMap.get(val);
            set.add(b);
        } else {
            Set set = new HashSet<Integer> ();
            set.add(b);
            bMap.put(val, set);
        }
    }

    private void recover(int i, int j, int k,
                         Map<Integer, Set<Integer>> rMap, Map<Integer, Set<Integer>> cMap, Map<Integer, Set<Integer>> bMap) {
        rMap.get(k).remove(i);
        cMap.get(k).remove(j);
        bMap.get(k).remove(i/3*3+j/3);
    }
}

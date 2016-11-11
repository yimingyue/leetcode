package leetcode.NQueen;

import java.util.ArrayList;

/**
 * Created by ymyue on 4/20/14.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        ArrayList<String[]> list = s.solveNQueens(8);
        for (String [] strs : list) {
            for (int i = 0; i < strs.length; i++)
                System.out.println(strs[i]);
            System.out.println();
        }
    }
}

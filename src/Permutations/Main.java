package Permutations;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/21/14
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        int [] num = {1, 2, 1, 2};
        ArrayList<ArrayList<Integer>> list = s.permute(num);
        for (ArrayList<Integer> mList : list) {
            for (int v : mList) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}

package leetcode.Anagrams;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/21/14
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        String [] strs = {"c", "c"};
        ArrayList<String> list = s.anagrams(strs);
        for (String string : list) {
            System.out.println(string);
        }
    }
}

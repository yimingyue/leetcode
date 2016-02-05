package leetcode.TextJustification;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/18/14
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
        ArrayList<String> ilist = s.fullJustify(words, 16);
        for (String str : ilist) {
            System.out.println(str);
        }
    }
}

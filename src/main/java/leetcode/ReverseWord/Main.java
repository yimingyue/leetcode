package leetcode.ReverseWord;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/29/14
 * Time: 10:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main (String [] args) {
        Solution s = new Solution();
        // test case 1
//        String str = "the sky is blue";

        // test case 2
//        String str = "hi!";

//        test case 3
        String str = " ";

        // test case 4
//        String str = "   a   b ";

        // test case 5
//        String str = "abc";
        str = s.reverseWords(str);
        System.out.println(str);
    }
}

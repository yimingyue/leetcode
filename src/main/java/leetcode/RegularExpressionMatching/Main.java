package leetcode.RegularExpressionMatching;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/3/14
 * Time: 11:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aaa", "ab*a*c*a"));
    }
}

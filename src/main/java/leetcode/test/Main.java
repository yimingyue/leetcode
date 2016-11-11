package leetcode.test;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/4/14
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main (String [] argv) {
        String s = "a,a";
        if (s.contains(","))
            s = s.replace(",", " ");
        System.out.println(s);
    }
}

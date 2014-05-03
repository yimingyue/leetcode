package EvaluateReversePolishNotation;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 5/3/14
 * Time: 8:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        String [] strs = {"4", "13", "5", "/", "+"};
        System.out.println(s.evalRPN(strs));
    }
}

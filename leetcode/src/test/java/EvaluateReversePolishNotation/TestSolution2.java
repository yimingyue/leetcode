package EvaluateReversePolishNotation;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/28/14
 * Time: 7:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestSolution2 {
    @Test
    public void TestAll() {
        String [] tokens = {"2", "1", "+", "3", "*"};
        Solution2 s = new Solution2();
        assertEquals(s.evalRPN(tokens), 9);
        String [] tokens2 = {"4", "13", "5", "/", "+"};
        assertEquals(s.evalRPN(tokens2), 6);
        String [] tokens3 = {"4"};
        assertEquals(s.evalRPN(tokens3), 4);
    }
}

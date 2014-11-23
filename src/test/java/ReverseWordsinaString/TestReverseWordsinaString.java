package ReverseWordsinaString;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/23/14
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestReverseWordsinaString {
    @Test
    public void TestAll() {
        Solution s = new Solution();
        String str = "the sky is blue";
        assertEquals(s.reverseWords(str), "blue is sky the");

        str = "the sky is  blue ";
        assertEquals(s.reverseWords(str), "blue is sky the");

        str = "  the sky is  blue ";
        assertEquals(s.reverseWords(str), "blue is sky the");
    }
}

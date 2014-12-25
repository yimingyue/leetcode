package SurroundedRegions;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/5/14
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestSurroundedRegions {
    @Test
    public void Test1 () {
        Solution solution = new Solution();
        String [] inputStrings =  {"XXX","XOX","XXX"};
        char [][] board = convertToChars(inputStrings);
        String[] expectStrings = {"XXX","XXX","XXX"};
        solution.solve(board);
        String[] outputStrings = convertToStrings(board);
        for (int i = 0; i < outputStrings.length; i++)
            assertEquals(outputStrings[i], expectStrings[i]);
    }

    private char[][] convertToChars(String[] strings) {
        int rows =  strings.length;
        int cols = strings[0].length();
        char[][] chars = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                chars[i][j] = strings[i].charAt(j);
        }
        return chars;
    }

    private String[] convertToStrings(char [][] chars) {
        int rows = chars.length;
        String [] strings = new String[rows];
        for (int i = 0; i < rows; i++) {
            strings[i] = new String(chars[i]);
        }
        return strings;
    }
}

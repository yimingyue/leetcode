package ExcelSheetColumnTitle;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/24/14
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String convertToTitle(int n) {
        assert(n > 0);
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            n = n-1;
            int m = n % 26;
            char c = (char)('A' + m);
            sb.append(c);
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}

/*
Key points:
 1) the counting is 1 based not 0 based. Hence, for each iteration, do n = n - 1 to make it 0 based. Then it's simple to map the number to character.
 */

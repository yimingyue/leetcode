package leetcode.ConvertaNumbertoHexadecimal;

/**
 * Created by ymyue on 9/24/16.
 */
public class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int c = (num >> ((7 -i) * 4)) & 0xf;
            if (c != 0 || sb.length() != 0) {
                if (c < 10)
                    sb.append(c);
                else
                    sb.append((char)('a' + c - 10));
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

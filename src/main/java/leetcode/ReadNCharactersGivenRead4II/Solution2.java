package leetcode.ReadNCharactersGivenRead4II;

/**
 * Created by ymyue on 7/31/16.
 */
public class Solution2 extends Read4 {
    private char[] cache = new char[4];
    private int start = 0;
    private int end = 0;
    public Solution2(String s) {
        super(s);
    }
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n <= end - start) {
            for (int i = 0; i < n; i++)
                buf[i] = cache[start++];
            return n;
        } else {
            int i = 0;
            while (start < end) {
                buf[i++] = cache[start++];
            }
            while (i < n) {
                end = read4(cache);
                if (end == 0)
                    return i;
                start = 0;
                while (i < n && start < end) {
                    buf[i++] = cache[start++];
                }
            }
            return i;
        }
    }
}

package leetcode.ReadNCharactersGivenRead4II;

/**
 * Created by ymyue on 7/13/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution extends Read4 {
    private char[] cache = new char[4];
    private int start = 0;
    private int end = 0;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int cacheSize = end - start;
        int minSize = Math.min(cacheSize, n);
        int length = 0;
        copy(buf, length, cache, start, start + minSize);
        start += minSize;
        length += minSize;
        if (length == n)
            return n;
        while (length < n) {
            start = 0;
            end = read4(cache);
            if (end == 0) {
                return length;
            } else {
                minSize = Math.min(end, n - length);
                copy(buf, length, cache, start, start + minSize);
                start += minSize;
                length += minSize;
            }
        }
        return length;
    }

    private void copy(char[] buf, int i, char[] cache, int start, int end) {
        for (int j = start; j < end; j++)
            buf[i+j-start] = cache[j];
    }
}

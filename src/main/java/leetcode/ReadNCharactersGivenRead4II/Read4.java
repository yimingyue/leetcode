package leetcode.ReadNCharactersGivenRead4II;

/**
 * Created by ymyue on 7/13/16.
 */
public class Read4 {
    char[] cache;
    int index = 0;
    public int read4(char[] buf) {
        int i = 0;
        while (i < 4 && index < cache.length)
            buf[i++] = cache[index++];
        return i;
    }
    public Read4(char[] input) {
        cache = input;
    }
    public Read4(String s) {
        this(s.toCharArray());
    }
    public Read4() {

    }
}

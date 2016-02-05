package leetcode.ReverseBits;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 1/18/16.
 */
public class Solution2 {
    // you need treat n as an unsigned value
    private static final Map<Byte, Integer> map = new HashMap<>();
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 4; i++) {
            r <<= 8;
            r += reverseByte((byte)(n & 0xFF));
            n >>>= 8;
        }
        return r;
    }
    private int reverseByte(byte b) {
        if (map.containsKey(b))
            return map.get(b);
        int v = 0;
        for (int i = 0; i < 8; i++) {
            v <<= 1;
            v |= b & 1;
            b >>>= 1;
        }
        map.put(b, v);
        return v;
    }
}

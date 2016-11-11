package leetcode.EncodeandDecodeStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 12/9/15.
 * Time complexity:
 *  - encode: O(n)
 *  - decode: O(n)
 * Space complexity:
 *  - encode: O(n)
 *  - decode: O(1)
 *
 */
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("/");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> rList = new ArrayList<>();
        int i = 0;
        while (i != s.length()) {
            int index = s.indexOf('/', i);
            int len = Integer.parseInt(s.substring(i, index));
            rList.add(s.substring(index+1, index+1+len));
            i = index+1+len;
        }
        return rList;
    }
}

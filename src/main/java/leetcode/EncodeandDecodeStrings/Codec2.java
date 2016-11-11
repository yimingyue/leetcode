package leetcode.EncodeandDecodeStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 10/20/16.
 */
public class Codec2 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j+1, j+1+length));
            i = j+1+length;
        }
        return result;
    }
}

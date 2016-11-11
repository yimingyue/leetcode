package leetcode.MaximumProductofWordLengths;

import java.util.Arrays;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution2 {
    public int maxProduct(String[] words) {
        Arrays.sort(words, (x, y) -> y.length() - x.length());
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++)
            mask[i] = getMask(words[i]);
        int result = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0)
                    result = Math.max(result, words[i].length() * words[j].length());
            }
        }
        return result;
    }

    private int getMask(String word) {
        int r = 0;
        for (char ch : word.toCharArray()) {
            r |= 1 << (ch-'a');
        }
        return r;
    }
}

package google.FillMatrix;

/**
 * Created by ymyue on 10/2/16.
 */
public class Solution {
    public int fillMatrix(String sentence, int m, int n) {
        sentence = sentence.trim();
        int[] index = new int[sentence.length()];
        int split = 0;
        for (int j = 0; j < sentence.length(); j++) {
            if (sentence.charAt(j) == ' ')
                split = j;
            index[j] = split;
        }
        int carry = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int len = m;
            len -= (sentence.length() - carry) + 1;
            count += (len + 1) / (sentence.length() + 1);
            len -= count * (sentence.length() + 1);
            if (len > 0)
                carry = sentence.length() - index[len];
        }
        return count;
    }
}

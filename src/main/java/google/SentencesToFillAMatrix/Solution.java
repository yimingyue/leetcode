package google.SentencesToFillAMatrix;

/**
 * Created by ymyue on 10/4/16.
 */
public class Solution {
    public int sentencesToFillAMatrix(int m, int n, String sentence) {
        int[] splits = new int[sentence.length()];
        int j = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ')
                j = i;
            splits[i] = j;
        }
        int carry = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int len = m;
            if (carry != 0) {
                len = m - carry - 1;
                count++;
            }
            count += (len+1) / sentence.length();
            int left = (len+1) % sentence.length();
            if (splits[left] != 0) {
                carry = sentence.length() - left - 1;
            } else
                carry = 0;
        }
        return count;
    }
}

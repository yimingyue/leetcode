package leetcode.SentenceScreenFitting;

/**
 * Created by ymyue on 10/8/16.
 */
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence.length == 0)
            return 0;
        int sum = 0;
        for (String word : sentence)
            sum += word.length();
        sum += sentence.length - 1;
        int[] index = new int[sum];
        int i = 0;
        int j = 0;
        for (String word : sentence) {
            for (int k = 0; k < word.length(); k++, j++)
                index[j] = i;
            i += word.length() + (i == 0 ? 0 : 1);
            if (j < sum)
                index[j++] = i;
        }
        int carry = 0;
        int count = 0;
        for (int k = 0; k < rows; k++) {
            int len = cols;
            if (len == carry) {
                count++;
                carry = 0;
            } else if (len > carry) {
                if (carry != 0) {
                    count++;
                    len -= carry + 1;
                    carry  = 0;
                }
                count += len / (sum+1);
                len = len % (sum+1);
                if (len == sum) {
                    count++;
                } else if (index[len] != 0) {
                    carry = sum - index[len]-1;
                }
            } else {
                if (index[len] != 0) {
                    carry = sum - index[sum - carry + len] - 1;
                } else
                    carry = 0;
            }
        }
        return count;
    }
}

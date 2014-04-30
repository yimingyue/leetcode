package ReverseWord;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/29/14
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.isEmpty())
            return s;

        // step 1 begins
        char [] c = s.toCharArray();
        int i = 0;
        int j = c.length-1;

        // reverse the string
        while (i < j) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
            i++;
            j--;
        }

        // step 2 begins
        int begin = 0; // begin index of a word
        int end = 0;   // end index of a word
        for (int k = 0; k <= c.length; k++) {
            // on 2 conditions it's end of a word - 1. a space; 2 end of the string
            if (k == c.length || c[k] == ' ') {
                end = k-1;
                i = begin;
                j = end;
                // reverse the word...
                while (i < j) {
                    char t = c[i];
                    c[i] = c[j];
                    c[j] = t;
                    i++;
                    j--;
                }
                // skip the continuous space
                while (k < c.length-1 && c[k+1] == ' ')
                    k++;
                begin = k+1;
            }
        }

        // using string builder to compose the return string without continuous space
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < c.length; k++) {
            if (c[k] == ' ') {
                if (k > 0 && c[k-1] == ' ')
                    continue;
            }
            sb.append(c[k]);
        }
        return sb.toString();
    }
}
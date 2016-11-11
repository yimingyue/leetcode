package google.MinimalLexicalOrderSubSequence;

/**
 * Created by ymyue on 10/1/16.
 */
public class Solution {
    public String findMin(String s, int k) {
        if (k > s.length())
            throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (sb.length() < k) {
            int idx = start;
            for (int i = start+1; s.length()-i>= k-sb.length(); i++) {
                if (s.charAt(i) < s.charAt(idx))
                    idx = i;
            }
            sb.append(s.charAt(idx));
            start = idx+1;
        }
        return sb.toString();
    }
}

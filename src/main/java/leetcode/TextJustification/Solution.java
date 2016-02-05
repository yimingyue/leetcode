package leetcode.TextJustification;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/18/14
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        int i = 0;
        ArrayList<String> rList = new ArrayList<String> ();
        if (words.length == 0 || L == 0)
            return rList;

        int count = 0;
        ArrayList<String> wordSet = new ArrayList<String> ();
        while (true) {
            String word = words[i++];
            if (word.length() > L)
                return rList;
            else if (word.length() == L) {
                if (count > 0) {
                    String line = redistribute(wordSet, L);
                    rList.add(line);
                    wordSet.clear();
                    i--;
                    count = 0;
                } else {
                    rList.add(word);
                    if (i == words.length)
                        return rList;
                }
            } else {
                if (count + word.length() > L) {
                    String line = redistribute(wordSet, L);
                    rList.add(line);
                    wordSet.clear();
                    count = 0;
                    i--;
                } else {
                    wordSet.add(word);
                    if (i == words.length) {
                        String line = redistributeLastLine(wordSet, L);
                        rList.add(line);
                        break;
                    }
                    else {
                        count += 1 + word.length();
                    }
                }
            }
        }
        return rList;
    }

    private String redistribute(ArrayList<String> wordSet, int L) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        int c = 0;
        for (String str : wordSet) {
            l += str.length();
            c++;
        }
        c--;
        if (l > L)
            return null;
        if (c == 0) {
            sb.append(wordSet.get(0));
            for (int k = 0; k < L-l; k++)
                sb.append(" ");
            return sb.toString();
        }

        int m = L - l;
        int w = m / c;
        int a = m - c*w;
        int i = 0;
        sb.append(wordSet.get(0));
        while (i < a) {
            for (int k = 0; k < w+1; k++)
                sb.append(" ");
            sb.append(wordSet.get(i+1));
            i++;
        }
        while (i < c) {
            for (int k = 0; k < w; k++)
                sb.append(" ");
            sb.append(wordSet.get(i+1));
            i++;
        }
        return sb.toString();
    }

    private String redistributeLastLine(ArrayList<String> wordSet, int L) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String str : wordSet) {
            sb.append(str);
            sb.append(" ");
            count += str.length() + 1;
        }
        if (L < count) {
            return sb.substring(0, L+1);
        }
        for (int k = 0; k < L - count; k++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}

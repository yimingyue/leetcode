package leetcode.WordBreakII;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ymyue on 7/10/16.
 * Time complexity: O(n^2) + ?
 * Space complexity: O(n^2)
 */
public class SolutionDPnBackTracking {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List[] prevBreak = new List[s.length()+1];
        boolean[] breakable = new boolean[s.length()+1];
        breakable[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    if (prevBreak[i] == null) {
                        prevBreak[i] = new ArrayList<> ();
                    }
                    prevBreak[i].add(j);
                }
            }
        }
        List<String> sentences = new ArrayList<> ();
        if (!s.isEmpty() && breakable[s.length()]) {
            buildSentences(s, sentences, s.length(), prevBreak, new ArrayList<String>());
        }
        return sentences;
    }

    private void buildSentences(String s, List<String> sentences, int i, List<Integer>[] prevBreak, List<String> words) {
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            for (int j = words.size()-1; j >= 0; j--)
                sb.append(words.get(j)).append(" ");
            sentences.add(sb.substring(0, sb.length() - 1));
            return;
        }
        for (int j : prevBreak[i]) {
            words.add(s.substring(j, i));
            buildSentences(s, sentences, j, prevBreak, words);
            words.remove(words.size() - 1);
        }
    }
}

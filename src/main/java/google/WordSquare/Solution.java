package google.WordSquare;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 10/10/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=200439&extra=&highlight=google&page=1
 */
public class Solution {
    public List<List<String>> wordSquare(String[] words, int length) {
        List<List<String>> result = new ArrayList<>();
        helper(result, new ArrayList<> (), length, words);
        return result;
    }

    private void helper(List<List<String>> result, List<String> list, int length, String[] words) {
        if (list.size() == length) {
            result.add(new ArrayList<> (list));
        } else {
            for (int k = 0; k < words.length; k++) {
                if (words[k].isEmpty() || words[k].length() > length)
                    continue;
                int i = list.size();
                int j = 0;
                while (j < list.size() && j < words[k].length() && i < list.get(j).length() && list.get(j).charAt(i) == words[k].charAt(j))
                    j++;
                if (j == words[k].length() || j == list.size()) {
                    String tmp = words[k];
                    list.add(words[k]);
                    words[k] = "";
                    helper(result, list, length, words);
                    list.remove(list.size()-1);
                    words[k] = tmp;
                }
            }
        }
    }
}




package leetcode.UniqueWordAbbreviation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity:
 *  - constructor O(n)
 *  - isUnique O(1)
 * Space complexity: O(n)
 */
public class ValidWordAbbr {
    Map<String, String> map = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            if (map.containsKey(abbr) && map.get(abbr) != null && !map.get(abbr).equals(word))
                map.put(abbr, null);
            else
                map.put(abbr, word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!map.containsKey(abbr) || (map.get(abbr) != null && map.get(abbr).equals(word)))
            return true;
        return false;
    }

    private String getAbbr(String word) {
        if (word.length() < 3)
            return word;
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0));
            sb.append(word.length()-2);
            sb.append(word.charAt(word.length()-1));
            return sb.toString();
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");

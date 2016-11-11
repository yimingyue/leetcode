package leetcode.WordBreakII;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution3 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List[] dp = new List[s.length()+1];

        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && dp[i] == null)
                continue;
            for (int j = i+1; j <= s.length(); j++) {
                if (wordDict.contains(s.substring(i, j))) {
                    if (dp[j] == null)
                        dp[j] = new ArrayList<Integer>();
                    dp[j].add(i);
                }
            }
        }

        List<String> result = new ArrayList<>();
        if (dp[s.length()] == null)
            return result;
        buildString(result, s, dp, s.length(), new ArrayList<>());
        return result;
    }

    private void buildString(List<String> result, String s, List[] dp, int j, List<String> list) {
        if (j == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = list.size()-1; i >= 0; i--) {
                sb.append(list.get(i));
                sb.append(' ');
            }
            result.add(sb.substring(0, sb.length()-1));
            return;
        }
        for (Object i : dp[j]) {
            list.add(s.substring((int)i, j));
            buildString(result, s, dp, (int) i, list);
            list.remove(list.size()-1);
        }
    }
}

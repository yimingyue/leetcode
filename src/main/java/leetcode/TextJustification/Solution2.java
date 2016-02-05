package leetcode.TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 12/27/15.
 */
public class Solution2 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rList = new ArrayList<>();
        int i = 0;
        List<String> list = new ArrayList<> ();
        while (true) {
            int len = 0;
            list.clear();
            while (len + words[i].length() <= maxWidth) {
                list.add(words[i]);
                len += words[i].length() + 1;
                i++;
                if (i == words.length) {
                    rList.add(getLastLine(list, maxWidth));
                    return rList;
                }
            }
            rList.add(getLine(list, maxWidth, len-1));
        }
    }

    private String getLine(List<String> list, int maxWidth, int len) {
        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0));
            for (int i = sb.length(); i <= maxWidth; i++)
                sb.append(' ');
        } else {
            int odd = (maxWidth - len) % (list.size() - 1);
            int i = 0;
            while (i < list.size()-1) {
                sb.append(list.get(i));
                sb.append(' ');
                for (int j = 0; j < (maxWidth - len) / (list.size()-1); j++)
                    sb.append(' ');
                if (i < odd)
                    sb.append(' ');
                i++;
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private String getLastLine(List<String> list, int maxWidth) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < list.size()-1) {
            sb.append(list.get(i));
            sb.append(' ');
            i++;
        }
        sb.append(list.get(i));
        for (int j = sb.length(); j < maxWidth; j++)
            sb.append(' ');
        return sb.toString();
    }
}

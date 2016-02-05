package leetcode.SimplifyPath;

import java.util.LinkedList;

/**
 * Created by ymyue on 12/29/15.
 */
public class Solution3 {
    public String simplifyPath(String path) {
        if (path.isEmpty())
            return path;
        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack = new LinkedList<> ();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.removeLast();
            } else if (!s.isEmpty() && !s.equals("."))
                stack.add(s);
        }
        for (String s : stack)
            sb.append("/" + s);
        if (stack.isEmpty())
            sb.append('/');
        return sb.toString();
    }
}

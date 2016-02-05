package leetcode.SimplifyPath;

/**
 * Created by ymyue on 12/29/15.
 */
public class Solution2 {
    public String simplifyPath(String path) {
        if (path.isEmpty())
            return path;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < path.length()) {
            char ch = path.charAt(i);
            if (ch == '/') {
                if (i == path.length()-1)
                    break;
                char ch1 = path.charAt(i+1);
                if (ch1 == '/') {
                    i++;
                } else if (ch1 == '.') {
                    if (i == path.length()-2)
                        break;
                    char ch2 = path.charAt(i+2);
                    if (ch2 == '/') {
                        i += 2;
                    } else if (ch2 == '.') {
                        if (i == path.length()-3) {
                            int j = sb.lastIndexOf("/");
                            if (j >= 0)
                                sb.delete(j, sb.length());
                            break;
                        }
                        char ch3 = path.charAt(i+3);
                        if (ch3 == '/') {
                            int j = sb.lastIndexOf("/");
                            if (j >= 0)
                                sb.delete(j, sb.length());
                            i += 3;
                        } else {
                            sb.append(ch);
                            sb.append(ch1);
                            sb.append(ch2);
                            sb.append(ch3);
                            i += 4;
                        }
                    } else {
                        sb.append(ch);
                        sb.append(ch1);
                        sb.append(ch2);
                        i += 3;
                    }
                } else {
                    sb.append(ch);
                    sb.append(ch1);
                    i += 2;
                }
            } else {
                sb.append(ch);
                i++;
            }
        }
        if (sb.length() == 0)
            sb.append('/');
        return sb.toString();
    }
}

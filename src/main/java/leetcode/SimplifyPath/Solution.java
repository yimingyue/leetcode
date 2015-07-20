package leetcode.SimplifyPath;

/**
 * Created by ymyue on 6/21/15.
 */
public class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == '/') {                                    // "/"      => "/"
                if (i == path.length()-1) {
                    if (sb.length() == 0)
                        sb.append("/");
                    break;
                }
                char ch1 = path.charAt(i+1);
                if (ch1 == '.') {                               // "/."     => "/"
                    if (i == path.length() -2) {
                        if (sb.length() == 0)
                            sb.append('/');
                        break;
                    }
                    char ch2 = path.charAt(i+2);
                    if (ch2 == '/') {                           // "/./"    => "/"
                        i = i+1;
                        continue;
                    } else if (ch2 == '.') {                    // "/.."
                        if (i == path.length()-3) {
                            if (sb.length() == 0) {
                                sb.append('/');                 // "/.."    =>  "/"
                                break;
                            } else {
                                int index = sb.lastIndexOf("/");    //  "/a/.." =>  "/"
                                if (index == -1)
                                    return null;                    //  "a/.."  =>  null
                                else if (index == 0) {
                                    sb.delete(index+1, sb.length());
                                    break;
                                }
                                else {
                                    sb.delete(index, sb.length());        //  "/a/.."
                                    break;
                                }
                            }
                        } else {
                            char ch3 = path.charAt(i+3);
                            if (ch3 == '/') {                       //  "/../"
                                if (sb.length() == 0) {
                                    i = i + 2;
                                    continue;
                                } else {
                                    int index = sb.lastIndexOf("/");
                                    sb.delete(index, sb.length());
                                    i = i + 2;
                                    continue;
                                }
                            } else {
                                sb.append("/..");
                                i = i + 2;
                                continue;
                            }
                        }
                    } else {
                        sb.append("/.");
                        i = i + 1;
                        continue;
                    }
                } else if (ch1 == '/') {
                    continue;
                } else {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

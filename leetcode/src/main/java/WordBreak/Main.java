package WordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/8/14
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        Set<String> set = new HashSet<String>();
        set.add("b");
        set.add("a");
        s.wordBreak("ab", set);
    }
}

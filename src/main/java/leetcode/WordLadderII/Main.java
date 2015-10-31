package leetcode.WordLadderII;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/20/14
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        Solution s = new Solution();
        String start = "cat";
        String end = "fin";
        HashSet<String> set = new HashSet<String>();
        String [] strs = {"ion","rev","che","ind","lie","wis","oct","ham","jag","ray","nun","ref","wig","jul","ken","mit","eel","paw","per","ola","pat","old","maj","ell","irk","ivy","beg","fan","rap","sun","yak","sat","fit","tom","fin","bug","can","hes","col","pep","tug","ump","arc","fee","lee","ohs","eli","nay","raw","lot","mat","egg","cat","pol","fat","joe","pis","dot","jaw","hat","roe","ada","mac"};
        for (String string : strs)
            set.add(string);
        System.out.println(s.findLadders(start, end, set));
    }
}

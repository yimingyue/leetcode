package leetcode.LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 5/21/15.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> rList = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return rList;
        rList.add("");
        List<String> iList = new ArrayList<> ();
        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            String str;
            switch (ch) {
                case '2' : str = "abc";
                    break;
                case '3' : str = "def";
                    break;
                case '4' : str = "ghi";
                    break;
                case '5' : str = "jkl";
                    break;
                case '6' : str = "mno";
                    break;
                case '7' : str = "pqrs";
                    break;
                case '8' : str = "tuv";
                    break;
                case '9' : str = "wxyz";
                    break;
                default : str = "";
            }
            if (str == null || str.isEmpty())
                continue;
            iList.clear();
            for (int j = 0; j < str.length(); j++) {
                String s = str.substring(j, j+1);
                for (String string : rList) {
                    iList.add(string + s);
                }
            }
            rList.clear();
            rList.addAll(iList);
        }
        return rList;
    }
}

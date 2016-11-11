package leetcode.StrobogrammaticNumber;

/**
 * Created by ymyue on 10/21/16.
 */
public class Solution2 {
    public boolean isStrobogrammatic(String num) {
        int i = 0;
        int j = num.length()-1;
        while (i <= j) {
            switch (num.charAt(i)) {
                case '0':
                case '1':
                case '8':
                    if (num.charAt(i) != num.charAt(j))
                        return false;
                    break;
                case '6':
                    if (num.charAt(j) != '9')
                        return false;
                    break;
                case '9':
                    if (num.charAt(j) != '6')
                        return false;
                    break;
                default:
                    return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

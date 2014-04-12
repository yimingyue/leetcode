package ValidPalindrome;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/21/14
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;

        char [] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            while (i < a.length && process(a[i]) == '^')
                i++;
            while (j >= 0 && process(a[j]) == '^')
                j--;

            if (i > j)
                return true;
            if (a[i] != a[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    private static char process(char c) {
        if (c >= 'a' && c <= 'z')
            return c;
        if (c >= '0' && c <= '9')
            return c;
        if (c >= 'A' && c <= 'Z')
            return Character.toLowerCase(c);
        return '^';
    }

    public static void main(String [] args) {
        System.out.println(isPalindrome("aA"));
    }
}

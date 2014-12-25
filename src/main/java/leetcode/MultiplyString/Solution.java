package MultiplyString;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/25/14
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        boolean positive = true;
        int m = num1.length();
        int n = num2.length();
        if (m == 0 || n == 0)
            return "";

        if (num1.charAt(0) == '-') {
            positive = !positive;
            num1 = num1.substring(1);
            m--;
        }
        if (num2.charAt(0) == '-') {
            positive = !positive;
            num2 = num2.substring(1);
            n--;
        }
        if (m == 0 || n == 0)
            return "";

        int [] a = new int [m+n];
        for (int j = 0; j < m; j++) {
            int v1 = num1.charAt(m-1-j) - '0';
            for (int k = 0; k < n; k++) {
                int v2 = num2.charAt(n-1-k) - '0';
                int v = v1*v2;
                v += a[j+k];
                a[j+k] = v % 10;
                a[j+k+1] += v / 10;
            }
        }
        StringBuilder sb = new StringBuilder ();
        if (!positive)
            sb.append("-");
        int i = m+n-1;
        while (i >= 0 && a[i] == 0) {
            i--;
        }
        if (i == -1)
            sb.append("0");
        while (i >= 0) {
            sb.append(a[i]);
            i--;
        }
        return sb.toString();
    }
}
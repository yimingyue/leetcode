package leetcode.MultiplyString;

/**
 * Created by ymyue on 5/25/15.
 */
public class Solution2 {
    public String multiply(String num1, String num2) {
        String r = "";
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty())
            return r;
        for (int i = num2.length()-1; i >= 0; i--) {
            String str = multiply(num1, num2.charAt(i));
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            for (int j = num2.length()-1; j > i; j--)
                sb.append('0');
            r = add(sb.toString(), r);
        }
        return r;
    }

    private String multiply(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        int b = Character.getNumericValue(ch);
        int carry = 0;
        for (int i = str.length()-1; i >= 0; i--) {
            int a = Character.getNumericValue(str.charAt(i));
            int m = a * b + carry;
            carry = m / 10;
            m = m % 10;
            sb.append(m);
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    private String add(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = str1.length() -1, j = str2.length() -1;
        while (i >= 0 || j >= 0) {
            int a, b;
            if (i >= 0)
                a = Character.getNumericValue(str1.charAt(i));
            else
                a = 0;
            if (j >= 0)
                b = Character.getNumericValue(str2.charAt(j));
            else
                b = 0;
            int sum = a + b + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            i--;
            j--;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}

package meetcode.ReadSumofDigits;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/7/15
 * Time: 7:02 AM
 * To change this template use File | Settings | File Templates.
 */
class Solution {
    public String readSum(String n) {
        if (n == null)
            return null;
        if (n.isEmpty())
            return "";
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            Character ch = n.charAt(i);
            sum += ch.getNumericValue(ch);
        }

        StringBuilder sb = new StringBuilder();
        String sumStr = Integer.toString(sum);
        String str;
        for (int i = 0; i < sumStr.length(); i++) {
            Character ch = sumStr.charAt(i);
            switch(ch) {
                case '0' : str = "zero";
                    break;
                case '1' : str = "one";
                    break;
                case '2' : str = "two";
                    break;
                case '3' : str = "three";
                    break;
                case '4' : str = "four";
                    break;
                case '5' : str = "five";
                    break;
                case '6' : str = "six";
                    break;
                case '7' : str = "seven";
                    break;
                case '8' : str = "eight";
                    break;
                case '9' : str = "nine";
                    break;
                default : str = "";
                    break;
            }
            sb.append(str);
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }
}
/**************************************************************
 Problem: 1
 User: virpro
 Language: Java
 Result: Accepted
 Time:121 ms
 Memory:18164 kb
 ****************************************************************/

package leetcode.MultiplyString;

public class Solution {
    public String multiply(String num1, String num2) {
        int [] arr = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int r = Character.getNumericValue(num1.charAt(num1.length()-1-i)) *
                        Character.getNumericValue(num2.charAt(num2.length()-1-j));
                arr[i+j] += r;
            }
        }

        for (int i = 0; i < arr.length-1; i++) {
            int val = arr[i];
            arr[i] = val % 10;
            arr[i+1] += val / 10;
        }

        int k = arr.length -1;
        while (arr[k] == 0 && k > 0)
            k--;
        StringBuilder sb = new StringBuilder();
        while (k >= 0) {
            sb.append(arr[k]);
            k--;
        }
        return sb.toString();
    }
}
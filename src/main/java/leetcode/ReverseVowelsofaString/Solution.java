package leetcode.ReverseVowelsofaString;

/**
 * Created by ymyue on 10/19/16.
 */
public class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length-1;
        while (i < j) {
            while (i < j && vowels.indexOf(array[i]) == -1)
                i++;
            while (i < j && vowels.indexOf(array[j]) == -1)
                j--;
            if (i < j)
                swap(array, i++, j--);
        }
        return String.valueOf(array);
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

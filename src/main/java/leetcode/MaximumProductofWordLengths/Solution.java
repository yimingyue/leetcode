package leetcode.MaximumProductofWordLengths;

/**
 * Created by ymyue on 8/3/16.
 * Time complexity: O(nk + n^2)
 * Space complexity: O(n)
 */
public class Solution {
    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++)
            mask[i] =  getMask(words[i]);

        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }

    private int getMask(String word) {
        int val = 0;
        for (char ch : word.toCharArray()) {
            val |= 1 << (ch-'a');
        }
        return val;
    }
}

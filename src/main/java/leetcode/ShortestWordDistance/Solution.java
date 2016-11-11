package leetcode.ShortestWordDistance;

/**
 * Created by ymyue on 6/12/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i = -words.length;
        int j = -words.length;
        int minDist = words.length;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1)) {
                minDist = Math.min(minDist, k - j);
                i = k;
            } else if (words[k].equals(word2)) {
                minDist = Math.min(minDist, k - i);
                j = k;
            }
        }
        return minDist;
    }
}

package leetcode.MinimumUniqueWordAbbreviation;

/**
 * Created by ymyue on 10/23/16.
 */
public class Solution2 {
    public String minAbbreviation(String target, String[] dictionary) {
        int[] masks = new int[dictionary.length];
        buildMask(target, masks, dictionary);
        for (int len = 1; len <= target.length(); len++) {
            int val = helper(len, masks, 0, target, 0);
            if (val != -1)
                return buildString(target, val);
        }
        return target;
    }

    private int helper(int len, int[] masks, int val, String target, int i) {
        if (len == 0 && i == target.length()) {
                for (int mask : masks)
                    if ((val & mask) == 0)
                        return -1;
                return val;
        }
        if (len < 0 || i == target.length())
            return -1;
        int next = helper(i != 0 && (val & 1) == 0 ? len : len-1, masks, val << 1, target, i+1);
        if (next != -1)
            return next;
        return helper(len-1, masks, (val << 1) + 1, target, i+1);
    }

    private void buildMask(String target, int[] masks, String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < target.length(); j++) {
                masks[i] <<= 1;
                if (target.charAt(j) != dictionary[i].charAt(j))
                    masks[i] |= 1;
            }
        }
    }

    private String buildString(String target, int val) {
        String str = "";
        int num = 0;
        for (int i = target.length()-1; i >= 0; i--) {
            if ((val & 1) == 0) {
                num++;
            } else {
                str = "" + target.charAt(i) + (num == 0 ? "" : num) + str;
            }
            val >>= 1;
        }
        return (num == 0 ? "" : num) + str;
    }
}

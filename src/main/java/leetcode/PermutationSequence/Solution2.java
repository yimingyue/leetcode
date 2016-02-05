package leetcode.PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 12/24/15.
 */
public class Solution2 {
    public String getPermutation(int n, int k) {
        int factorial = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (k > factorial/(n-i))

            if (k >= factorial) {
                sb.append(list.get(k/factorial-1));
                list.remove(k/factorial-1);
                k %= factorial;
            } else {
                sb.append(list.get(0));
                list.remove(0);
            }
        }
        return sb.toString();
    }
}

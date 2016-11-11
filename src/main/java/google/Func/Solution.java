package google.Func;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 10/10/16.
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=200339&highlight=google
 * Round 1
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int steps(int n) {
        if (n == 1)
            return 0;
        if (map.containsKey(n))
            return map.get(n);
        int step = 1 + steps(func(n));
        map.put(n, step);
        return step;
    }

    private int func(int n) {
        if (n == 1)
            return n;
        if ((n & 1) == 1)
            return 3*n+1;
        else
            return n / 2;
    }
}

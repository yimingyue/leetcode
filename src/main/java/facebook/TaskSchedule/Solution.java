package facebook.TaskSchedule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 2/3/16.
 */
public class Solution {
    public int totalTime(int[] tasks, int interval) {
        if (tasks == null || tasks.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.containsKey(task) ? map.get(task)+1 : 1);
        }
        int countOfMax = 0;
        int max = 0;
        for (int count : map.values()) {
            if (count > max) {
                max = count;
                countOfMax = 1;
            } else if (count == max)
                countOfMax++;
        }
        if (countOfMax >= interval) {
            return tasks.length;
        }
        int total = (max-1) * ( interval+1) + countOfMax;
        return Math.max(total, tasks.length);
    }
}

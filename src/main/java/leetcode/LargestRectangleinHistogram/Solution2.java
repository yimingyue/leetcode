package leetcode.LargestRectangleinHistogram;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/25/14
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution2 {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0)
            return 0;
        List<Integer> list = new ArrayList<>(height.length+1);
        for (int h : height)
            list.add(h);
        list.add(0);

        int max = 0;
        int area = 0;
        Stack<Integer> stack = new Stack<> ();
        for (int i = 0; i < list.size(); i++) {
            if (stack.isEmpty() || list.get(i) > list.get(stack.peek()))
                stack.push(i);
            else {
                int h = list.get(stack.pop());
                if (stack.isEmpty())
                    area = h * i;
                else
                    area = h * (i - stack.peek()-1);
                max = Math.max(max, area);
                i--;
            }
        }
        return max;
    }
}

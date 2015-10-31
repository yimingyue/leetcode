package leetcode.PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 10/10/15.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>(rowIndex+1);
        list.add(1);
        if (rowIndex == 0)
            return list;
        ArrayList<Integer> nList = new ArrayList<>(rowIndex+1);
        nList.add(1);
        int i = 0;
        while (i < rowIndex) {
            for (int j = 1; j < list.size(); j++) {
                nList.set(j, list.get(j-1)+list.get(j));
            }
            nList.add(1);
            i++;
            ArrayList<Integer> tmp = list;
            list = nList;
            nList = tmp;
        }
        return list;
    }
}

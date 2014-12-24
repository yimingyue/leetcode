package FindTopKSum;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/14/14
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public List<Integer> findTopKSum(int[] A, int[] B, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(2*k, new MyComparator());
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        queue.add(A[0]+B[0]);
        List<Integer> iList = new ArrayList<>();
        iList.add(0);
        iList.add(0);
        List<List<Integer>> rList = new ArrayList<>();
        rList.add(iList);
        map.put(A[0] + B[0],  rList);
        boolean[][] visited = new boolean[A.length][B.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B.length; j++)
                visited[i][j] = false;
        while (k > 0) {
            k--;
            int sum = queue.poll();
            list.add(sum);
            rList = map.get(sum);
            iList = rList.get(rList.size()-1);
            rList.remove(rList.size()-1);
            int i = iList.get(0);
            int j = iList.get(1);
            if (!visited[i+1][j]) {
                sum = A[i+1] + B[j];
                queue.add(sum);
                iList = new ArrayList<>();
                iList.add(i+1);
                iList.add(j);
                if (map.containsKey(sum)) {
                    map.get(sum).add(iList);
                } else {
                    rList = new ArrayList<>();
                    rList.add(iList);
                    map.put(sum, rList);
                }
                visited[i+1][j] = true;
            }

            if (!visited[i][j+1]) {
                sum = A[i] + B[j+1];
                queue.add(sum);
                iList = new ArrayList<>();
                iList.add(i);
                iList.add(j+1);
                if (map.containsKey(sum)) {
                    map.get(sum).add(iList);
                } else {
                    rList = new ArrayList<>();
                    rList.add(iList);
                    map.put(sum, rList);
                }
                visited[i][j+1] = true;
            }
        }
        return list;
    }

    class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            return b-a;
        }
    }
}

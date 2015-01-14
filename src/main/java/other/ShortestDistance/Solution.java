package other.ShortestDistance;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 1/14/15
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int shortestDistance(boolean[][] board, int x1, int y1, int x2, int y2) {
        if (board.length == 0 || board[0].length == 0)
            throw new IllegalArgumentException();
        if (x1 < 0 || x1 > board.length
                || x2 < 0 || x2 > board.length
                || y1 < 0 || y1 > board[0].length
                || y2 < 0 || y2> board[0].length)
            throw new IllegalArgumentException();

        int m = board.length;
        int n = board[0].length;
        int p1 = x1 * n + y1;
        int p2 = x2 * n + y2;
        int [] distance = new int[m*n];
        for (int i = 0; i < distance.length; i++)
            distance[i] = -1;
        distance[p1] = 0;
        Set<Integer> set = new HashSet<>();
        set.add(p1);
        int dis = 0;
        while (!set.isEmpty()) {
            Set<Integer> nSet = new HashSet<>();
            for (int index : set) {
                if (index == p2)
                    return dis;
                int x = index / n;
                int y = index % n;
                if (x+1 < m && board[x+1][y] && distance[(x+1)*n+y] == -1) {
                    nSet.add((x+1)*n+y);
                    distance[(x+1)*n+y] = dis+1;
                }
                if (x-1 >= 0 && board[x-1][y] && distance[(x-1)*n+y] == -1) {
                    nSet.add((x-1)*n+y);
                    distance[(x-1)*n+y] = dis+1;
                }
                if (y+1 < n && board[x][y+1] && distance[x*n+y+1] == -1) {
                    nSet.add(x*n+y+1);
                    distance[x*n+y+1] = dis+1;
                }
                if (y-1 >= 0 && board[x][y-1] && distance[x*n+y-1] == -1) {
                    nSet.add(x*n+y-1);
                    distance[x*n+y-1] = dis+1;
                }
            }
            dis++;
            set = nSet;
        }
        return -1;
    }
}

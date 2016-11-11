package leetcode.PacificAtalantic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/10/14
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public List<List<Integer>> findPoints(int[][] array) {
        // Return a list of points. Each point is represented by a list contains the x and y coordinate
        List<List<Integer>> rList = new ArrayList<>();

        if (array.length == 0 || array[0].length == 0)
            return rList;
        int m = array.length;
        int n = array[0].length;
        boolean[][] visited = new boolean[m][n]; // record if the point has been visited before
        boolean [][] state = new boolean[m][n]; // record if the water at the point can flow to Pacific
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
                state[i][j] = false;
            }
        }

        // start dfs from the first row (upper side)
        for (int i = 0; i < n; i++) {
            if (!visited[0][i])
                dfs1(array, visited, state, 0, i);
        }
        // dfs for the first column (left side)
        for (int i = 1; i < m; i++) {
            if (!visited[i][0])
                dfs1(array, visited, state, i, 0);
        }

        // reset visited matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        // start dfs from bottom
        for (int i = 0; i < n; i++) {
            if (!visited[m-1][i])
                dfs2(rList, array, visited, state, m-1, i);
        }

        // start dfs from right
        for (int i = 1; i < m; i++) {
            if (!visited[i][n-1])
                dfs2(rList, array, visited, state, i, n-1);
        }

        return rList;
    }

    private void dfs1(int[][] array, boolean [][] visited, boolean [][] state, int i, int j) {
        visited[i][j] = true;
        state[i][j] = true;
        if (i > 0) {
            if (!visited[i-1][j] && array[i][j] <= array[i-1][j])
                dfs1(array, visited, state, i-1, j);
        }
        if (i < array.length-1) {
            if (!visited[i+1][j] && array[i][j] <= array[i+1][j])
                dfs1(array, visited, state, i+1, j);
        }
        if (j > 0) {
            if (!visited[i][j-1] && array[i][j] <= array[i][j-1])
                dfs1(array, visited, state, i, j-1);
        }
        if (j < array[0].length-1) {
            if (!visited[i][j+1] && array[i][j] <= array[i][j+1])
                dfs1(array, visited, state, i, j+1);
        }
    }

    private void dfs2(List<List<Integer>> rList, int[][] array, boolean[][] visited, boolean [][] state, int i, int j) {
        visited[i][j] = true;
        if (state[i][j]) { // it can flows to Pacific according to dfs1
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(j);
            rList.add(list);
        }
        if (i > 0) {
            if (!visited[i-1][j] && array[i][j] <= array[i-1][j])
                dfs2(rList, array, visited, state, i-1, j);
        }
        if (i < array.length-1) {
            if (!visited[i+1][j] && array[i][j] <= array[i+1][j])
                dfs2(rList, array, visited, state, i+1, j);
        }
        if (j > 0) {
            if (!visited[i][j-1] && array[i][j] <= array[i][j-1])
                dfs2(rList, array, visited, state, i, j-1);
        }
        if (j < array[0].length-1) {
            if (!visited[i][j+1] && array[i][j] <= array[i][j+1])
                dfs2(rList, array, visited, state, i, j+1);
        }
    }
}

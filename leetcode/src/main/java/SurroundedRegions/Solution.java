package SurroundedRegions;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 12/5/14
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0)
            return;
        int cols = board[0].length;
        if (cols == 0)
            return;

        Stack<Integer> rStack = new Stack<> ();
        Stack<Integer> cStack = new Stack<> ();
        boolean [][] visited = new boolean[rows][cols];
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                rStack.push(0);
                cStack.push(j);
                visited[0][j] = true;
            }
            if (board[rows-1][j] == 'O') {
                rStack.push(rows-1);
                cStack.push(j);
                visited[rows-1][j] = true;
            }
        }

        for (int i = 1; i < rows-1; i++) {
            if (board[i][0] == 'O') {
                rStack.push(i);
                cStack.push(0);
                visited[i][0] = true;
            }
            if (board[i][cols-1] == 'O') {
                rStack.push(i);
                cStack.push(cols-1);
                visited[i][cols-1] = true;
            }
        }

        while (!rStack.isEmpty()) {
            int i = rStack.pop();
            int j = cStack.pop();
            if (i > 0 && board[i-1][j] == 'O' && !visited[i-1][j]) {
                rStack.push(i-1);
                cStack.push(j);
                visited[i-1][j] = true;
            }
            if (i < rows-1 && board[i+1][j] == 'O' && !visited[i+1][j]) {
                rStack.push(i+1);
                cStack.push(j);
                visited[i+1][j] = true;
            }
            if (j > 0 && board[i][j-1] == 'O' && !visited[i][j-1]) {
                rStack.push(i);
                cStack.push(j-1);
                visited[i][j-1] = true;
            }
            if (j < cols-1 && board[i][j+1] == 'O' && !visited[i][j+1]) {
                rStack.push(i);
                cStack.push(j+1);
                visited[i][j+1] = true;
            }
        }

        for (int i = 1; i < rows-1; i++) {
            for (int j = 1; j < cols-1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

package leetcode.SmallestRectangleEnclosingBlackPixels;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ymyue on 7/27/16.
 */
public class SolutionBFS {
    public int minArea(char[][] image, int x, int y) {
        int up = x;
        int down = x;
        int left = y;
        int right = y;

        int height = image.length;
        if (height == 0)
            return 0;
        int width = image[0].length;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x*width+y);
        image[x][y] = '0';
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int id = queue.poll();
                x = id / width;
                y = id % width;

                up = Math.min(x, up);
                down = Math.max(x, down);
                left = Math.min(y, left);
                right = Math.max(y, right);
                if (x > 0 && image[x-1][y] == '1') {
                    image[x-1][y] = '0';
                    queue.offer((x-1)*width+y);
                }
                if (x < height-1 && image[x+1][y] == '1') {
                    image[x+1][y] = '0';
                    queue.offer((x+1)*width+y);
                }
                if (y > 0 && image[x][y-1] == '1') {
                    image[x][y-1] = '0';
                    queue.offer(x*width+y-1);
                }
                if (y < width-1 && image[x][y+1] == '1') {
                    image[x][y+1] = '0';
                    queue.offer(x*width+y+1);
                }
            }
        }
        return (down - up + 1) * (right - left +1);
    }
}

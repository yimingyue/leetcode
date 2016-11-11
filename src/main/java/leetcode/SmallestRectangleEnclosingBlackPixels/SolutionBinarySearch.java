package leetcode.SmallestRectangleEnclosingBlackPixels;

/**
 * Created by ymyue on 7/27/16.
 * Time complexity: O(m*logn+n*logm)
 */
public class SolutionBinarySearch {
    public int minArea(char[][] image, int x, int y) {
        return (searchRight(image, y) - searchLeft(image, y)) * (searchBottom(image, x) - searchTop(image, x));
    }

    private int searchLeft(char[][] image, int y) {
        int left = 0;
        int right = y-1;
        while (left <= right) {
            boolean black = false;
            int mid = left + (right - left) / 2;
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    black = true;
                    break;
                }
            }
            if (black)
                right = mid-1;
            else
                left = mid+1;
        }
        return left;
    }

    private int searchRight(char[][] image, int y) {
        int left = y+1;
        int right = image[0].length-1;
        while (left <= right) {
            boolean black = false;
            int mid = left + (right - left) / 2;
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    black = true;
                    break;
                }
            }
            if (black)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

    private int searchTop(char[][] image, int x) {
        int up = 0;
        int down = x-1;
        while (up <= down) {
            boolean black = false;
            int mid = up + (down - up) / 2;
            for (int i = 0; i < image[mid].length; i++) {
                if (image[mid][i] == '1') {
                    black = true;
                    break;
                }
            }
            if (black)
                down = mid-1;
            else
                up = mid+1;
        }
        return up;
    }

    private int searchBottom(char[][] image, int x) {
        int up = x+1;
        int down = image.length-1;
        while (up <= down) {
            boolean black = false;
            int mid = up + (down - up) / 2;
            for (int i = 0; i < image[mid].length; i++) {
                if (image[mid][i] == '1') {
                    black = true;
                    break;
                }
            }
            if (black)
                up = mid+1;
            else
                down = mid-1;
        }
        return up;
    }
}

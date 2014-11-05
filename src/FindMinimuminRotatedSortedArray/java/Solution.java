package FindMinimuminRotatedSortedArray.java;

public class Solution {
    public int findMin(int [] num) {
        if (num.length == 0)
            return -1;
        return findMin(num, 0, num.length-1);
    }

    private int findMin(int [] num, int start, int end) {
        if (start == end)
            return num[start];
        if (start == (end-1))
            return num[start] < num[end] ? num[start] : num[end];

        int mid = (start + end) / 2;
        if (num[start] < num[mid] && num[mid] < num[end])
            return num[start];
        if (num[start] > num[mid] && num[mid] < num[end])
            return findMin(num, start + 1, mid);
        if (num[start] < num[mid] && num[mid] > num[end])
            return findMin(num, mid+1, end);
        return -1;
    }
}

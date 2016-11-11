package leetcode.common.utils;

import java.util.List;

/**
 * Created by ymyue on 6/5/16.
 */
public class Median {
    public double getMedian(int[] arr) {
        if (arr.length % 2 == 1)
            return findKth(arr, arr.length / 2);
        else
            return ((double)findKth(arr, (arr.length-1)/2) + (double)findKth(arr, arr.length/2)) / 2;
    }

    public double getMedian(List<Integer> list) {
        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list)
            arr[i++] = num;
        return getMedian(arr);
    }

    private int findKth(int[] arr, int k) {
        return findKth(arr, 0, arr.length-1, k);
    }

    private int findKth(int[] arr, int start, int end, int k) {
        int p = partition(arr, start, end);
        if (p == k)
            return arr[p];
        else if (p < k)
            return findKth(arr, p + 1, end, k);
        else
            return findKth(arr, start, p - 1, k);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start-1;
        int j = end+1;
        while (i < j) {
            for (++i; arr[i] < pivot; i++);
            for (--j; arr[j] > pivot; j--);
            if (i < j)
                swap(arr, i, j);
        }
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

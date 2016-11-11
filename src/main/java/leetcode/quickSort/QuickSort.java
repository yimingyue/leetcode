package leetcode.quickSort;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/15/14
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {
    void quickSort(int [] a) {
        quickSort(a, 0, a.length-1);
    }

    void quickSort(int [] a, int start, int end) {
        if (start > end)
            return;
        int q = partition(a, start, end);
        quickSort(a, start, q-1);
        quickSort(a, q+1, end);
    }

    int partition(int [] a, int start, int end) {
        int pivot = a[end];
        int i = 0;
        int j = 0;
        while (j <= end) {
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
            j++;
        }
        a[end] = a[i];
        a[i] = pivot;
        return i;
    }
}

package threesum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/4/14
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        mergeSort(num);
        int distance = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < num.length-2; i++) {
            int j = i+1;
            int k = num.length-1;
            while (j < k) {
                int x = num[i] + num[j] + num[k];
                if (x == target)
                    return target;
                int margin = target - x;
                if (Math.abs(margin) < distance) {
                    distance = Math.abs(margin);
                    sum = x;
                }
                if (margin > 0)
                    j++;
                else
                    k--;
            }
        }
        return sum;
    }

    private void mergeSort(int [] num) {
        mergeSort(num, 0, num.length-1);
    }

    private void mergeSort(int [] num, int start, int end) {
        if (start == end)
            return;
        else {
            int mid = (start+end) / 2;
            mergeSort(num, start, mid);
            mergeSort(num, mid+1, end);
            merge(num, start, mid, end);
        }
    }

    private void merge(int [] num, int start, int mid, int end) {
        int [] left = new int [mid-start+2];
        int [] right = new int [end-mid+1];
        int i = 0;
        while (i <= mid-start) {
            left[i] = num[start+i];
            i++;
        }
        left[i] = Integer.MAX_VALUE;

        int j = 0;
        while (j < end-mid) {
            right [j] = num[mid+1+j];
            j++;
        }
        right[j] = Integer.MAX_VALUE;

        int k = start;
        i = 0;
        j = 0;
        while (k <= end) {
            if (left[i] < right[j]) {
                num[k] = left[i];
                i++;
            } else {
                num[k] = right[j];
                j++;
            }
            k++;
        }
    }
}
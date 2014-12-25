package leetcode.foursum;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/5/14
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> ();
        if (num.length < 4)
            return list;
        mergeSort(num);
        for (int m = 0; m < num.length-3; m++) {
            for (int n = m+1; n < num.length-2; n++) {
                if (n > m+1 && num[n] == num[n-1])
                    continue;
                int i = n+1;
                int j = num.length-1;
                while (i < j) {
                    int x = num[i] + num[m] + num[n] + num[j];
                    if (x == target) {
                        ArrayList<Integer> iList = new ArrayList<Integer> ();
                        iList.add(num[m]);
                        iList.add(num[n]);
                        iList.add(num[i]);
                        iList.add(num[j]);
                        list.add(iList);
                        i++;
                        while (i < j && num[i] == num[i-1])
                            i++;
                        if (i == j)
                            break;
                        j--;
                        while (j > i && num[j] == num[j+1])
                            j--;
                        if (j == i)
                            break;
                    } else if (x > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
        }
        Stack<Character> s = new Stack<Character>();
        s.push('c');
        return list;
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
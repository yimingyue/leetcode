package leetcode.quickSort;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 4/15/14
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        int [] a = {9, 5, 3, 6, 4};
        QuickSort q = new QuickSort();
        q.quickSort(a);
        System.out.println(a);
    }
}

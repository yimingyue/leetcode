package leetcode.common.utils;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 5/22/16.
 */
public class Utils {
    public static ListNode arrayToListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int val : arr) {
            ListNode q = new ListNode(val);
            p.next = q;
            p = q;
        }
        return dummy.next;
    }

    public static ListNode getListFromArray(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int val : arr) {
            p.next = new ListNode(val);
            p = p.next;
        }
        return dummy.next;
    }

    public static int[] getArrayFromList(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        int[] arr = new int[count];
        p = head;
        int i = 0;
        while (p != null) {
            arr[i++] = p.val;
            p = p.next;
        }
        return arr;
    }

    public static boolean assertLinkedListEquals(ListNode p, ListNode q) {
        while (p != null || q != null) {
            if (p == null || q == null || p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public static void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.format("%8d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length-1)
                System.out.print(" ,");
        }
        System.out.println();
        System.out.println("-------------------------");
    }
}

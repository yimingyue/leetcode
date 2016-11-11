package leetcode.ReorderList;

import leetcode.common.ds.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/8/14
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(4);
        head.next = p1;
        p1.next = p2;
//        p2.next = p3;

        Solution s = new Solution();
        s.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

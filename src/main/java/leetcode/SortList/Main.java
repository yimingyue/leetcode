package leetcode.SortList;

import leetcode.common.ds.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/27/13
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] argv) {
        ListNode l0 = new ListNode(10);
        ListNode l1  = new ListNode(5);
        l0.next = l1;
        ListNode l2 = new ListNode(19);
        l1.next = l2;
        ListNode l3 = new ListNode(18);
        l2.next = l3;
        ListNode l4 = new ListNode(13);
        l3.next = l4;

        Solution2 s = new Solution2();
        ListNode p = s.sortList(l0);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}

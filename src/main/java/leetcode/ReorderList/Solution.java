package leetcode.ReorderList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/8/14
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same threesum.Solution2 instance will be reused for each test case.
        if (head == null)
            return;

        int n = 0;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        if (n <= 1)
            return;

        int mid = n / 2;

        ListNode s = head;
        ListNode t = head.next;
        int i = 0;
        while (i < mid) {
            s = s.next;
            t = t.next;
            i++;
        }
        s.next = null;
        while (i < n) {
            ListNode tmp = t.next;
            t.next = s;
            s = t;
            t = tmp;
            i++;
        }

        p = head;
        while (p != s && p != null && s!= null) {
            ListNode pn = p.next;
            ListNode sn = s.next;
            p.next = s;
            s.next = pn;
            p = pn;
            s = sn;
        }
    }
}

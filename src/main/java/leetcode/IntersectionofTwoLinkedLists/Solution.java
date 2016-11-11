package leetcode.IntersectionofTwoLinkedLists;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/16/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = getLength(headA);
        int count2 = getLength(headB);
        ListNode p = headA;
        ListNode q = headB;
        while (count1 < count2) {
            q = q.next;
            count2--;
        }
        while (count1 > count2) {
            p = p.next;
            count1--;
        }
        while (p != null) {
            if (p == q)
                return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
}

package leetcode.DeleteNodeinaLinkedList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 6/16/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode p = node;
        ListNode q = null;
        while (p.next != null) {
            p.val = p.next.val;
            q = p;
            p = p.next;
        }
        q.next = null;
    }
}

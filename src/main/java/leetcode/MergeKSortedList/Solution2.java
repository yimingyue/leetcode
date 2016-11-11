package leetcode.MergeKSortedList;

import leetcode.common.ds.ListNode;

import java.util.PriorityQueue;

/**
 * Created by ymyue on 6/16/16.
 * Time complexity: O(nlogK)
 * Space complexity: O(k)
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<> (lists.length, (x, y) -> x.val - y.val);
        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }
        ListNode dummy = new ListNode (0);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null)
                pq.offer(node.next);
        }
        return dummy.next;
    }
}

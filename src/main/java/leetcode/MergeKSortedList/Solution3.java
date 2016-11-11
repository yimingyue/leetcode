package leetcode.MergeKSortedList;

import leetcode.common.ds.ListNode;

import java.util.PriorityQueue;

/**
 * Created by ymyue on 10/20/16.
 */
public class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<> ((x, y) -> x.val - y.val);
        for (ListNode node : lists)
            pq.offer(node);
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next!= null)
                pq.offer(node.next);
        }
        return dummy.next;
    }
}

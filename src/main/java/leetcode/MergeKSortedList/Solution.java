package leetcode.MergeKSortedList;

import leetcode.common.ds.ListNode;

/**
 * Created by ymyue on 5/24/15.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        for (int i = lists.length/2-1; i>= 0; i--)
            maxifyHeap(lists, i);
        ListNode head = null;
        ListNode p = null;
        while (lists[0] != null) {
            if (head == null) {
                head = lists[0];
                p = lists[0];
            } else {
                p.next = lists[0];
                p = lists[0];
            }
            lists[0] = lists[0].next;
            maxifyHeap(lists, 0);
        }
        return head;
    }

    private void maxifyHeap(ListNode[] lists, int i) {
        if (2*i+1 >= lists.length)
            return;
        if (2*i+2 >= lists.length) {
            if (lists[2*i+1] == null)
                return;
            if (lists[i] != null && lists[i].val < lists[2*i+1].val)
                return;
            ListNode tmp = lists[i];
            lists[i] = lists[2*i+1];
            lists[2*i+1] = tmp;
            return;
        }
        if (lists[2*i+1] == null && lists[2*i+2] == null)
            return;
        if (lists[2*i+1] == null) {
            if (lists[i] != null && lists[i].val < lists[2*i+2].val)
                return;
            ListNode tmp = lists[i];
            lists[i] = lists[2*i+2];
            lists[2*i+2] = tmp;
            maxifyHeap(lists, 2*i+2);
        }
        if (lists[2*i+2] == null) {
            if (lists[i] != null && lists[i].val < lists[2*i+1].val)
                return;
            ListNode tmp = lists[i];
            lists[i] = lists[2*i+1];
            lists[2*i+1] = tmp;
            maxifyHeap(lists, 2*i+1);
        }
        if (lists[i] != null && lists[i].val < lists[2*i+1].val && lists[i].val < lists[2*i+2].val)
            return;
        if (lists[2*i+1].val < lists[2*i+2].val) {
            ListNode tmp = lists[i];
            lists[i] = lists[2*i+1];
            lists[2*i+1] = tmp;
            maxifyHeap(lists, 2*i+1);
        } else {
            ListNode tmp = lists[i];
            lists[i] = lists[2*i+2];
            lists[2*i+2] = tmp;
            maxifyHeap(lists, 2*i+2);
        }
    }
}

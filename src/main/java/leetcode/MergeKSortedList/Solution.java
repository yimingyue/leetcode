package leetcode.MergeKSortedList;

/**
 * Created by ymyue on 5/24/15.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode head = null, p = null;
        ListNode t = getSmallest(lists);
        while (t != null) {
            if (head == null) {
                head = t;
                p = head;
            } else {
                p.next = t;
                p = p.next;
            }
            t = getSmallest(lists);
        }
        return head;
    }

    private ListNode getSmallest(ListNode[] lists) {
        int val = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null)
                continue;
            if (lists[i].val < val) {
                index = i;
                val = lists[i].val;
            }
        }
        if (index == -1)
            return null;
        ListNode p = lists[index];
        lists[index] = p.next;
        return p;
    }
}

package leetcode.LinkedListRandomNode;

import leetcode.common.ds.ListNode;

import java.util.Random;

/**
 * Created by ymyue on 9/18/16.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Solution {
    ListNode head;
    Random random;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int val = head.val;
        ListNode p = head.next;
        int index = 1;
        while (p != null) {
            index++;
            if (random.nextInt(index) == 0)
                val = p.val;
            p = p.next;
        }
        return val;
    }
}

package leetcode.CopyListwithRandomPointer;

import leetcode.common.ds.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 6/7/16.
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode p = head;
        RandomListNode q = dummy;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            map.put(p, copy);
            q.next = copy;
            q = copy;
            p = p.next;
        }

        p = head;
        q = dummy.next;
        while (p != null) {
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }
}

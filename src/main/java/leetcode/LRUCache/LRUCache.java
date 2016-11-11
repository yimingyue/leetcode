package leetcode.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 1/10/16.
 *  07/07/2016
 */
public class LRUCache {
    class DoublyLinkedListNode {
        int key;
        int val;
        DoublyLinkedListNode pre;
        DoublyLinkedListNode next;
        public DoublyLinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    int capacity;
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    Map<Integer, DoublyLinkedListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyLinkedListNode node = map.get(key);
            if (node != tail) {
                node.next.pre = node.pre;
                if (node == head)
                    head = node.next;
                else
                    node.pre.next = node.next;
                node.next = null;
                node.pre = tail;
                tail.next = node;
                tail = node;
            }
            return node.val;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                head = head.next;
            }
            DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
            map.put(key, node);
            if (tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }
    }
}

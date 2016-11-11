package leetcode.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymyue on 10/18/16.
 */
public class LRUCache3 {
    public static class DoublyLinkedListNode {
        int key;
        int val;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        public DoublyLinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    Map<Integer, DoublyLinkedListNode> map;
    int capacity;

    public LRUCache3(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        DoublyLinkedListNode node = map.get(key);
        moveToTail(node);
        return node.val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkedListNode node = map.get(key);
            moveToTail(node);
            node.val = value;
        } else {
            DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
            map.put(key, node);
            addNode(node);
            if (map.size() > capacity) {
                map.remove(head.key);
                removeHead();
            }
        }
    }

    private void moveToTail(DoublyLinkedListNode node) {
        if (tail == node)
            return;
        if (head == node) {
            head = head.next;
            head.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }

    private void addNode(DoublyLinkedListNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    private void removeHead() {
        if (head == null)
            return;
        else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
    }
}

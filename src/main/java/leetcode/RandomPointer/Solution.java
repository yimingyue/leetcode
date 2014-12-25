package RandomPointer;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 2/10/14
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        // convert linkedlist to arraylist
        ArrayList<RandomListNode> list = new ArrayList<RandomListNode>();
        RandomListNode r = head;
        while (r != null) {
            list.add(r);
            r = r.next;
        }

        // store index into another arraylist
        ArrayList <Integer> iList = new ArrayList<Integer> ();
        r = head;
        while (r != null) {
            RandomListNode s = r.random;
            if (s == null)
                iList.add(-1);
            else {
                iList.add(list.indexOf(s));
            }
            r = r.next;
        }

        // copy linkedlist
        r = head;
        RandomListNode nHead = new RandomListNode(r.label);
        nHead.next = null;
        nHead.random = null;
        RandomListNode p = nHead;
        while (r.next != null) {
            RandomListNode q = new RandomListNode(r.next.label);
            p.next = q;
            p = q;
            r = r.next;
        }


        // convert new linkedlist to arraylist
        ArrayList<RandomListNode> nList = new ArrayList<RandomListNode> ();
        p = nHead;
        while (p != null) {
            nList.add(p);
            p = p.next;
        }

        // copy random pointers
        p = nHead;
        int index = 0;
        while (p != null) {
            int rIndex = iList.get(index);
            if (rIndex == -1)
                p.random = null;
            else
                p.random = nList.get(rIndex);
            p = p.next;
        }
        return nHead;
    }
}

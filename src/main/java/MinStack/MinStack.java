package MinStack;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/23/14
 * Time: 9:08 AM
 * To change this template use File | Settings | File Templates.
 */
class MinStack {
    public void push(int x) {
        Node n = new Node(x);
        if (minNode == null)
            minNode = n;
        else if (x < minNode.getValue()) {
            n.setLast(minNode);
            minNode = n;
        }
        list.add(n);
    }

    public void pop() {
        if (list.size() == 0)
            return;
        Node n = list.get(list.size()-1);
        if (minNode == n)
            minNode = n.getLast();
        list.remove(list.size()-1);
    }

    public int top() {
        if (list.size() == 0)
            return Integer.MIN_VALUE;
        Node n = list.get(list.size()-1);
        return n.getValue();
    }

    public int getMin() {
        if (minNode != null)
            return minNode.getValue();
        else return Integer.MIN_VALUE;
    }

    private class Node {
        private Node lastMin = null;
        private int value;
        Node (int x) {
            value = x;
        }
        public void setLast(Node n) {
            lastMin = n;
        }
        public int getValue() {
            return value;
        }
        public Node getLast() {
            return lastMin;
        }
    }

    ArrayList<Node> list = new ArrayList<>();
    Node minNode = null;
}

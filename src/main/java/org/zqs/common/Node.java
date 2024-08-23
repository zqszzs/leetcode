package org.zqs.common;

public class Node {

    public int val;
    public Node next;
    public Node random;
    public Node(int val) { this.val = val; }
    public Node(int val, Node next) { this.val = val; this.next = next; }

    public static Node buildListNode (int [] params) {
        Node first = null, pre = null;
        for (int param : params) {
            Node listNode = new Node(param);
            if (first == null) {
                first = listNode;
            } else {
                pre.next = listNode;
            }
            pre = listNode;
        }

        return first;
    }
}

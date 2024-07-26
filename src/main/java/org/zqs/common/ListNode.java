package org.zqs.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode buildListNode (int [] params) {
        ListNode first = null, pre = null;
        for (int param : params) {
            ListNode listNode = new ListNode(param);
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
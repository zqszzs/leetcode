package org.zqs.linklist;

import org.zqs.common.ListNode;

public class ReverseLinkList {

    public static void main(String[] args) {

        int [] params = new int[]{1, 2, 3, 4};

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

        ListNode listNode = reverseLinkList(first);
        System.out.println(listNode);
    }

    public static ListNode reverseLinkList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode pre = null;
        int i = 0;
        while (true) {
            if (current == null) {
                break;
            }
            if (i % 2 == 0) {
                pre = current;
            } else {
                int preVal = pre.val;
                int currentVal = current.val;

                pre.val = currentVal;
                current.val = preVal;
            }
            current = current.next;
            i++;
        }

        return head;
    }
}

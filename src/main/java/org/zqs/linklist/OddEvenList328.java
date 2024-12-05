package org.zqs.linklist;

import org.zqs.common.ListNode;

// todo
public class OddEvenList328 {


    public static void main(String[] args) {

        int [] params = new int [] {1,2,3,4,5};

        ListNode listNode = ListNode.buildListNode(params);

        ListNode reuslt = oddEvenList(listNode);

        System.out.println(reuslt != null ? reuslt.val : "null");
    }



    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;

        ListNode rightFirst = head.next;
        ListNode right = rightFirst;

        while (right != null && right.next != null) {
            left.next = right.next;
            right.next = right.next.next;
            left = left.next;
            right = right.next;
        }

        left.next = rightFirst;
        return head;
    }
}

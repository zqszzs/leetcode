package org.zqs.linklist;

import org.zqs.common.ListNode;

/**
 * 两数相加
 */
public class AddTwoNumbers21 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int [] {2,4,3});
        ListNode l2 = ListNode.buildListNode(new int [] {5,6,4});
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);

        ListNode current = dummy;
        boolean isOverLimit = false;
        while (l1 != null && l2 != null) {
            int value =  l1.val + l2.val + (isOverLimit ? 1 : 0);
            if (value >= 10) {
                isOverLimit = true;
                value = value - 10;
            } else {
                isOverLimit = false;
            }

            ListNode next = new ListNode(value);
            current.next = next;
            current = next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int value =  l1.val + (isOverLimit ? 1 : 0);
            if (value >= 10) {
                isOverLimit = true;
                value = value - 10;
            } else {
                isOverLimit = false;
            }

            ListNode next = new ListNode(value);
            current.next = next;
            current = next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int value =  l2.val + (isOverLimit ? 1 : 0);
            if (value >= 10) {
                isOverLimit = true;
                value = value - 10;
            } else {
                isOverLimit = false;
            }

            ListNode next = new ListNode(value);
            current.next = next;
            current = next;
            l2 = l2.next;
        }

        if (isOverLimit) {
            ListNode next = new ListNode(1);
            current.next = next;
        }

        return dummy.next;
    }
}

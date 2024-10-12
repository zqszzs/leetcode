package org.zqs.linklist;

import org.zqs.common.ListNode;

public class DeleteDuplicates82 {


    public static void main(String[] args) {

        int [] params = new int [] {1,1,1,2,3};

        ListNode listNode = ListNode.buildListNode(params);

        ListNode reuslt = deleteDuplicates(listNode);

        System.out.println(reuslt != null ? reuslt.val : "null");
    }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        boolean hasDuplicated = false;
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            if (current.val != next.val) {
                if (hasDuplicated) {
                    pre.next = next;
                    hasDuplicated = false;
                } else {
                    pre = current;
                }
            } else {
                pre.next = null;
                hasDuplicated = true;
            }
            current = next;
        }

        return dummy.next;
    }
}

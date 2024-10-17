package org.zqs.linklist;

import org.zqs.common.ListNode;

/**
 * 2095. 删除链表的中间节点
 */
public class DeleteMiddle2095 {


    public static void main(String[] args) {

        int [] params = new int [] {1};

        ListNode listNode = ListNode.buildListNode(params);

        ListNode reuslt = deleteMiddle1(listNode);

        System.out.println(reuslt != null ? reuslt.val : "null");
    }


    public static ListNode deleteMiddle(ListNode head) {

        ListNode curr = head;
        int length = 0;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        if (length < 2) {
            return null;
        }

        ListNode pre = null;
        curr = head;
        for (int i = 0; i < length / 2; i++) {
            pre = curr;
            curr = curr.next;
        }
        pre.next = curr.next;
        return head;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static ListNode deleteMiddle1(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slowPre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPre.next = slow.next;
        return head;
    }
}

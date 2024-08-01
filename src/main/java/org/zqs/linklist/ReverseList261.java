package org.zqs.linklist;

import org.zqs.common.ListNode;

public class ReverseList261 {
    public static void main(String[] args) {
        int [] params = new int[]{1, 2, 3, 4, 5};

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

        ListNode listNode = reverseList(first);
        System.out.println(listNode);
    }


    /**
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 <- 2    3 - 4 - 5
     * current: 1
     * next: 2
     * nextnext: 3-4-5
     *
     * next-current
     *
     */

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 人之初生，过去为空，现在从头，未来不存
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            // 未来出于现在
            ListNode next = current.next;
            // 现在指向过去
            current.next = pre;
            // 现在成为过去
            pre = current;
            // 未来成为现在
            current = next;
        }
        //生之将亡，唯过去返回彼岸
        return pre;
    }
}

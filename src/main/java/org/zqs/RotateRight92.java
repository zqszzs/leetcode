package org.zqs;

import org.zqs.common.ListNode;

/**
 * 旋转链表
 */
public class RotateRight92 {

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

        //ListNode listNode = reverseBetween(first, 2);
       // System.out.println(listNode);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode node = head;
        ListNode tail = head;
        for (int i = 0; i < right; i++) {

        }

        return null;

    }
}

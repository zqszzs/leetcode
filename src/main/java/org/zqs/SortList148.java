package org.zqs;

import org.zqs.common.ListNode;

/**
 * leetcode 第148题
 */
public class SortList148 {

    public static void main(String[] args) {
        int [] params = new int [] {-1,5,3,4,0};
        ListNode listNode = sortList(ListNode.buildListNode(params), null);
        System.out.println(listNode);
    }

    public static ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;

            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode leftListNode = sortList(head, slow);
        ListNode rightListNode = sortList(slow, tail);
        return merge(leftListNode, rightListNode);
    }

    public static ListNode merge(ListNode leftListNode, ListNode rightListNode) {
        // 创建哨兵节点
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        ListNode node1 = leftListNode, node2 = rightListNode;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                dummy.next = node2;
                node2 = node2.next;
            } else {
                dummy.next = node1;
                node1 = node1.next;
            }
            dummy = dummy.next;
        }

        if (node1 != null) {
            dummy.next = node1;
        }
        if (node2 != null) {
            dummy.next = node2;
        }

        return result.next;
    }
}

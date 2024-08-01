package org.zqs;

import org.zqs.common.ListNode;

/**
 * 重排链表
 */
public class ReorderList143 {


    /**
     *  1  2  3  4
     *  1  4  2  3
     *
     * @param args
     */
    public static void main(String[] args) {
        int [] params = new int [] {1,2,3,4, 5};
        ListNode listNode = ListNode.buildListNode(params);
        reorderList1(ListNode.buildListNode(params));
        System.out.println(listNode);
    }


    /**
     *
     * 头插法
     * L0 - Ln - L1 - Ln-1 - L2 - Ln-2
     *
     * 1 - 2 - 3 - 4 - 5
     *        current
     * 1 - 5 - 2 - 3 - 4
     * 1- 5 - 2 - 4 - 3
     * @param head
     *
     * 时间复杂度 o(n^2)
     *
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 前一个节点
        ListNode pre = head;
        // 前一个节点的下一个节点
        ListNode preNext = null;
        // 最后一个节点
        ListNode last = null;
        // 最后一个节点的上一个节点
        ListNode lastPre = null;

        while (pre != null) {
            last = pre;
            while (last.next != null) {
                lastPre = last;
                last = last.next;
            }

            if (pre == lastPre) {
                break;
            }

            preNext = pre.next;
            pre.next = last;
            last.next = preNext;
            lastPre.next = null;

            pre = preNext;
        }
    }

    public static void reorderList1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        right = reverse(right);
        ListNode left = head;
        mergeList(left, right);
    }

    private static ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode next = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }

        return pre;
    }

    private static void mergeList(ListNode left, ListNode right) {
        while (left != null && right != null) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;

            left.next = right;
            right.next = leftNext;

            left = leftNext;
            right = rightNext;
        }
    }
}

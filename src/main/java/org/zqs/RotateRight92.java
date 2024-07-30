package org.zqs;

import org.zqs.common.ListNode;

/**
 * 旋转链表
 */
public class RotateRight92 {

    public static void main(String[] args) {
        int [] params = new int[]{3,5};

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
        ListNode listNode = reverseBetween3(first, 1, 2);
        System.out.println(listNode);
    }


    /**
     * 方法1：穿针引线, 找出开始反转的left - right节点， left前一个节点pre，right后一个节点next，反转left - right为right - left段，
     * pre连接 right -  left， left连接next
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        if (left > right) {
            throw new RuntimeException("参数不合理");
        }

        // 待转开始节点上一个节点
        ListNode pre = null;
        // 待转开始节点
        ListNode first = null;
        // 当前节点
        ListNode current = head;
        for (int i = 1; i < right; i++) {
            if (current == null) {
                throw new RuntimeException("参数不合理");
            }
            if (i == left - 1) {
                pre = current;
            }
            if (i == left) {
                first = current;
            }
            current = current.next;
        }

        //待转结束节点下一个节点
        ListNode next =  current.next;

        //待转结束节点next置为空， 断掉链表，方便中间节点反转
        current.next = null;

        // 反转中间节点
        ListNode listNode= reverse(first);

        // pre不为空说明不是从头节点开始反转
        if (pre != null) {
            pre.next = listNode;
        } else {
            // pre为空,说明从头节点开始反转，head指向反转后的头节点
            head = listNode;
        }

        // 反转后，反转前开始节点变为结束节点，next指向后一段
        first.next = next;

        return head;
    }

    /**
     * 方法1：穿针引线, 代码优化，利用哨兵节点简化代码
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // 走left - 1步找出leftNode的前一个节点
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 走right - left + 1步找出rightNode
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 反转左节点
        ListNode leftNode = pre.next;
        // 反转段节点后一段
        ListNode successor = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        pre.next = rightNode;
        leftNode.next = successor;

        return dummyNode.next;
    }


    /**
     * 方法1：头插法
     * @param head
     * @param left
     * @param right
     * @return
     *     left   right
     *  1  2   3   4   5
     */
    public static ListNode reverseBetween3(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // 开始反转的节点
        ListNode startNode = null;

        // 反转节点上一个节点
        ListNode pre = null;

        // 左一个节点
        ListNode leftNode = null;

        // 当前节点
        ListNode current = dummyNode;

        // 下一个右节点
        ListNode rightNode = null;
        for (int i = 0; i <= right; i++) {
            if (i == left - 1) {
                pre = current;
            }
            if (i == left) {
                startNode = current;
            }

            rightNode = current.next;
            if (i > left && i <= right) {
                current.next = leftNode;
                pre.next = current;

            }

            leftNode = current;
            current = rightNode;
        }

        startNode.next = rightNode;

        return dummyNode.next;
    }


    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }
}

package org.zqs;

import org.zqs.common.ListNode;

/**
 * 旋转链表
 */
public class RotateRight61 {

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

        ListNode listNode = rotateRight(first, 2);
        System.out.println(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        int n = length - k % length;
        if (n == length) {
            return head;
        }

        tail.next = head;
        while (n-- > 0) {
            tail = tail.next;
        }
        ListNode result = tail.next;
        tail.next = null;
        return result;
    }

    /**
     * 双指针
     * @param head
     * @param k
     * @return
     * 1, 2, 3, 4, 5
     * tail前进 (k % length) 步
     *      tail
     * pre指向头节点，和tail一起向前走
     * pre  tail
     *   pre    tail
     *      pre   tail
     * 走到最后一步, tail连接head形成环，head变成pre下一个节点，pre断开环
     *
     */
    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        int n = k % length;
        // tail 前进 n步
        tail= head;
        while (n-- > 0) {
            tail = tail.next;
        }

        ListNode pre = head;
        while (tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }

        tail.next = head;
        ListNode result = pre.next;
        pre.next = null;

        return result;
    }


    public ListNode rotateRight3(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        //统计链表长度
        int num=1;
        // tail向前走k%n步
        while (k>0){
            if (tail.next == null) {
                tail = head;
                k--;
                k=k%num;
                continue;
            } else {
                tail = tail.next;
            }
            num++;
            k--;
        }
        // pre和tail同步向前走，直达tail走到表尾
        ListNode pre = head;
        while (tail.next != null) {
            tail = tail.next;
            pre = pre.next;
        }
        // 截断、拼接pre后面的节点至表前
        tail.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }

}

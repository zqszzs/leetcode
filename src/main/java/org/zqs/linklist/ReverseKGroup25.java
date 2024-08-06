package org.zqs.linklist;

import org.zqs.common.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 */
public class ReverseKGroup25 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildListNode(new int [] {1,2,3,4,5});

        ListNode listNode1 = reverseKGroup(listNode, 1);

        System.out.println(listNode1);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 开始翻转的前一个结点
        ListNode startPre = dummy;
        // 开始翻转节点
        ListNode start = head;
        // 迭代节点
        ListNode current = head;

        int i = 1;
        while (current != null) {
            if (i % k == 0) {
                if (start != current) {
                    // 结束节点下一个节点
                    ListNode next = current.next;
                    // 断链
                    current.next = null;
                    // 翻转片段
                    reverse(start);
                    // 翻转后start变成尾节点，并指向指向下一个节点
                    start.next = next;
                    // 翻转后startPre指向新的头节点
                    startPre.next = current;

                    // start节点尾节点
                    current = startPre = start;
                    // next为下一次翻转的开始节点
                    start = next;
                }
            }
            current = current.next;
            i++;
        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre  = current;
            current = next;
        }

        return pre;
    }
}

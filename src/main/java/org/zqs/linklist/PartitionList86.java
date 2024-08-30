package org.zqs.linklist;

import org.zqs.common.ListNode;

/**
 * 分隔链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 */
public class PartitionList86 {

    public static void main(String[] args) {

        ListNode node = ListNode.buildListNode(new int [] {1,4,3,2,5,2});
        node = partition(node, 3);
        System.out.println(node);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode preNode = null;
        ListNode startNode = head;
        while (startNode != null) {
            if (startNode.val >= x) {
                 break;
            }

            preNode = startNode;
            startNode = startNode.next;
        }



        ListNode currentNode = startNode;
        ListNode pre = null;
        while (currentNode != null) {
            if (currentNode.val < x) {
                if (preNode == null) {
                    head = currentNode;
                } else {
                    preNode.next = currentNode;
                }

                ListNode tmp = currentNode.next;
                // 当前节点指针指向大于等于x节点
                currentNode.next = startNode;
                preNode = currentNode;
                currentNode = tmp;
                pre.next = tmp;
            } else {
                pre = currentNode;
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}

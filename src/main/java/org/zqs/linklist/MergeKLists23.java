package org.zqs.linklist;

import org.zqs.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 第21题
 */
public class MergeKLists23 {

    public static void main(String[] args) {
        int [][] param = new int[][] {{1,4,5},{1,3,4},{2,6}};

        ListNode[] lists = new ListNode[param.length];
        for (int i = 0; i < param.length; i++) {
            int [] ints = param[i];
            ListNode first = null, pre = null;
            for (int anInt : ints) {
                ListNode listNode = new ListNode(anInt);
                if (first == null) {
                    first = listNode;
                } else {
                    pre.next = listNode;
                }
                pre = listNode;
            }
            lists[i] = first;
        }

        ListNode listNode = mergeKLists3(lists);
        System.out.println(listNode);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = null;
        for (ListNode listNode : lists) {
            if (pre == null) {
                pre = listNode;
            } else {
                pre = mergeKLists(pre, listNode);
            }
        }
        return pre;
    }

    public static ListNode mergeKLists(ListNode leftListNode, ListNode rightListNode) {
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


    /**
     * 方式2 优先级队列
     */

    public static ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue((Comparator<ListNode>) (o1, o2) -> o1.val - o2.val);

        for (ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }
            priorityQueue.add(listNode);
        }


        ListNode dummy = new ListNode(0);
        ListNode current =  dummy;

        while (!priorityQueue.isEmpty()) {
            ListNode listNode = priorityQueue.poll();
            current.next = listNode;
            current = current.next;
            ListNode next = listNode.next;
            if (next != null) {
                priorityQueue.add(next);
            }

        }

        return dummy.next;
    }

    /**
     * 方式3 分治法
     */

    public static ListNode mergeKLists3(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (r + l) >> 1;


        return mergeKLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
}

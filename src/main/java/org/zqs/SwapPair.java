package org.zqs;

import org.zqs.common.ListNode;

public class SwapPair {

    public static void main(String[] args) {

        int [] params = new int[]{1};

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

        ListNode listNode = swapPairs(first);
        System.out.println(listNode);
    }


    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode pre = null;
        int i = 0;
        while (true) {
            if (current == null) {
                break;
            }
            if (i % 2 == 0) {
                pre = current;
            } else {
                int preVal = pre.val;
                int currentVal = current.val;

                pre.val = currentVal;
                current.val = preVal;
            }
            current = current.next;
            i++;
        }

        return head;
    }

    /**
     * 哨兵节点
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        ListNode node0 = new ListNode();
        ListNode node1 = head;

        return head;
    }
}

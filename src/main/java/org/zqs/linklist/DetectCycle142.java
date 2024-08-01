package org.zqs.linklist;

import org.zqs.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 环形链表
 * 返回环形链表的第一个节点
 */
public class DetectCycle142 {

    public static void main(String[] args) {

        int [] params = new int [] {-1,5,3,4,0};


        ListNode listNode = buildDetectCycleNode(params, 3);

        ListNode reuslt = detectCycle2(listNode);

        System.out.println(reuslt != null ? reuslt.val : "null");

    }

    static ListNode buildDetectCycleNode(int [] params, int pos) {

        ListNode listNode = ListNode.buildListNode(params);
        ListNode pre = listNode;
        ListNode cycle = null;
        int i = 1;
        while (pre.next != null) {
            if (pos == i) {
                cycle = pre;
            }
            pre = pre.next;
            i++;
        }
        pre.next = cycle;

        return listNode;
    }

    /**
     * 哈希表
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();

        ListNode curr = head;
        while (curr != null) {
            if (map.containsKey(curr)) {
                return curr;
            }
            map.put(curr, 1);
            curr = curr.next;
        }

        return null;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode lptr = head;
                while (lptr != slow) {
                    lptr = lptr.next;
                    slow = slow.next;
                }

                return lptr;
            }

        }

        return null;
    }

}

package org.zqs.linklist;

import org.zqs.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class XiaoJiaoLianBiao160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet();
        ListNode current = headA;
        while (current != null) {
            nodeSet.add(current);
            current = current.next;
        }

        current = headB;
        while (current != null) {
            if (nodeSet.contains(current)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    /**
     *
     *  a + b = b + a
     *  1个从a开始，1个从b开始，a遍历完遍历b，b遍历完遍历a
     *  第一个相当的节点就是相交节点
     *
     *
     *
     *
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;
        while (true) {
            if (preA == preB) {
                return preA;
            }
            if (preA == null) {
                preA = headB;
            } else {
                preA = preA.next;
            }
            if (preB == null) {
                preB = headA;
            } else {
                preB = preB.next;
            }
        }
    }
}

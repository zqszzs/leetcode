package org.zqs.linklist;

import org.zqs.common.ListNode;
import org.zqs.common.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList138 {


    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 哨兵节点
        Node dummy = new Node(-1);
        Map<Node, Node> randomMap = new HashMap<>();

        Node current = head;
        Node random = null;
        Node copyPre = dummy;
        while (current != null) {
            Node node = randomMap.get(current);
            if (node == null) {
                node = new Node(current.val);
                randomMap.put(current, node);
            }

            if (random != null) {
                Node copyRandom  = randomMap.get(random);
                if (copyRandom == null) {
                    copyRandom = new Node(random.val);
                    randomMap.put(random, copyRandom);
                }
                copyPre.random = copyRandom;
            }

            // 上一个节点next指针指向当前节点
            copyPre.next = node;
            random = current.random;
            current = current.next;
            copyPre = node;
        }

        // next为空会推出循环，导致最后一个不为空current节点还未给random赋值
        if (random != null) {
            Node copyRandom  = randomMap.get(random);
            copyPre.random = copyRandom;
        }

        return dummy.next;
    }
}

package org.zqs;

import org.zqs.common.ListNode;

public class SortList {


    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {

        ListNode pre = head;
        ListNode current = head;
        while (true) {
            if (current == null) {
                break;
            }

            if (current.val < pre.val) {
                ListNode tmp = pre.next;
                ListNode next = current.next;


            }




        }



    }
}

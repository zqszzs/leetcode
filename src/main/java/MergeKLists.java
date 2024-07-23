import java.util.ArrayList;
import java.util.List;

public class MergeKLists {

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

        mergeKLists(lists);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (ListNode list : lists) {
            result = mergeKLists(list, result);
        }
        return result;
    }

    public static ListNode mergeKLists(ListNode target, ListNode dest) {
        if (dest == null) {
            return target;
        }

        ListNode result = new ListNode();

        ListNode next1 = target;
        ListNode next2 = dest;
        while (next1 != null || next2 != null) {
            if (next1 == null) {
                result.next = next2;
            }
            if (next2 == null) {
                result.next = next1;
            }

            int targetValue = next1.val;
            int destValue = next2.val;

            if (targetValue > destValue) {
                next2 =  next2.next;
            } else {
                next1 = next1.next;
            }
            ListNode listNode = new ListNode(targetValue > destValue ? destValue : targetValue);
            result.next = listNode;
        }
        return dest;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

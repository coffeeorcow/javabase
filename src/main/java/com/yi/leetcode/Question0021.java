package com.yi.leetcode;

public class Question0021 {

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            do {
                sb.append(node.val);
                sb.append(", ");
                node = node.next;
            } while (node != null);
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            return sb.toString();
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        node.next = l1 == null ? l2 : l1;

        return head.next;
    }

    public static ListNode mergeTwoLists_recv(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists_recv(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_recv(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(2);
        l2.next = new ListNode(3);

        System.out.println(mergeTwoLists(l1, l2));
        System.out.println(mergeTwoLists_recv(l1, l2));

    }

}

package com.yi.leetcode;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode toList(int[] vals) {
        if (vals.length == 0) {
            return null;
        }
        ListNode head = new ListNode(vals[0]);
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        do {
            sb.append(cur.val);
            sb.append(" ");
            cur = cur.next;
        } while (this.next != null);
        return sb.toString();
    }
}

public class Question0206 {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode n = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return n;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.toList(new int[] {1, 2, 3, 4});
        System.out.println(list);
        System.out.println(reverseList(list));
    }
}

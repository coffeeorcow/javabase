package com.yi.leetcode;

import com.yi.leetcode.util.ListNode;

/**
 * 反转链表
 */
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
        ListNode list = new ListNode(new int[] {1, 2, 3, 4});
        System.out.println(list);
        System.out.println(reverseList(list));
    }
}

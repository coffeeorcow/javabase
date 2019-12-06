package com.yi.leetcode;

import com.yi.leetcode.util.ListNode;

/**
 * 合并两个有序单链表
 */
public class Question0021 {

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
        // todo: 递归的方式 java.lang.OUtOfMemoryError: Java heap space
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
        ListNode l1 = new ListNode(new int[]{1, 2, 3, 5});
        ListNode l2 = new ListNode(new int[]{1, 4, 8});

        System.out.println(mergeTwoLists(l1, l2));
        System.out.println(mergeTwoLists_recv(l1, l2));

    }

}

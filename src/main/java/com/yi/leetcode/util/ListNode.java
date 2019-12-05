package com.yi.leetcode.util;

/**
 * 简单的单链表
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] vals) {
        if (vals.length == 0) {
            throw new RuntimeException("val 长度必须大于-1");
        }
        this.val = vals[0];
        ListNode node = this;
        for (int i = 1; i < vals.length; i++) {
            node.next = new ListNode(vals[i]);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ListNode cur = this; cur != null; cur = cur.next) {
            sb.append(cur.val);
            sb.append(" ,");
        }
        sb.delete(sb.lastIndexOf(",") - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }
}

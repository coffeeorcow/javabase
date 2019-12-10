package com.yi.leetcode.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode val(int val) {
        return new TreeNode(val);
    }

    public TreeNode ofLeft(TreeNode node) {
        this.left = node;
        return this;
    }

    public TreeNode ofRight(TreeNode node) {
        this.right = node;
        return this;
    }

    public TreeNode left() {
        return this.left;
    }

    public TreeNode right() {
        return this.right;
    }
}

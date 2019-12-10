package com.yi.leetcode;

import com.yi.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 * <p>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */
public class Question0144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        parseNode(root, list);
        return list;
    }

    private static void parseNode(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        parseNode(node.left, list);
        parseNode(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.val(1);
        tree.ofLeft(TreeNode.val(2)).left().left();
        TreeNode right = tree.ofRight(TreeNode.val(3)).right();
        right.ofLeft(TreeNode.val(4));
        right.ofRight(TreeNode.val(5));

        List<Integer> result = preorderTraversal(tree);
        System.out.println(result);
    }

}

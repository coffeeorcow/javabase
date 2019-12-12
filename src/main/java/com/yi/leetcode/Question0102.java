package com.yi.leetcode;

import com.yi.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层次遍历
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question0102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        list.add(temp);
        do {
            nodes = parseNode(nodes);
            if (nodes.size() > 0) {
                temp = new ArrayList<>();
                for (TreeNode node : nodes) {
                    temp.add(node.val);
                }
                list.add(temp);
            }
        } while(nodes.size() > 0);

        return list;
    }

    private static List<TreeNode> parseNode(List<TreeNode> nodes) {
        List<TreeNode> results = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                results.add(node.left);
            }
            if (node.right != null) {
                results.add(node.right);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.val(1).ofLeft(TreeNode.val(2)).ofRight(TreeNode.val(3));
        TreeNode right = tree.right();
        right.ofLeft(TreeNode.val(4)).ofRight(TreeNode.val(5));

        List<List<Integer>> results = levelOrder(tree);
        results.forEach(System.out::println);
    }

}

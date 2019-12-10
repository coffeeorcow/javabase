package com.yi.leetcode;

import com.yi.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question0094 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        parseNode(root, list);
        return list;
    }

    private static void parseNode(TreeNode node, List<Integer> list) {
        if (node == null)
            return;

        parseNode(node.left, list);
        list.add(node.val);
        parseNode(node.right, list);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.val(1);
        tree.ofLeft(TreeNode.val(2)).left().left();
        TreeNode right = tree.ofRight(TreeNode.val(3)).right();
        right.ofLeft(TreeNode.val(4));
        right.ofRight(TreeNode.val(5));

        List<Integer> result = inorderTraversal(tree);
        System.out.println(result);
    }

}

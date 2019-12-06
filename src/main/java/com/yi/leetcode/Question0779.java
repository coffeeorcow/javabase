package com.yi.leetcode;

/**
 * 第 k 个语法符号
 *
 * Examples:
 * Input: N = 1, K = 1
 * Output: 0
 *
 * Input: N = 2, K = 1
 * Output: 0
 *
 * Input: N = 2, K = 2
 * Output: 1
 *
 * Input: N = 4, K = 5
 * Output: 1
 *
 * Explanation:
 * row 1: 0
 * row 2: 01
 * row 3: 0110
 * row 4: 01101001
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar
 */
public class Question0779 {

    public static int kthGrammer(int N, int K) {
        if (N == 1) {
            return 0;
        }
        return (~K & 1) ^ kthGrammer(N - 1, (K + 1) / 2);
    }

    public static void main(String[] args) {
        System.out.println(kthGrammer(4, 5));
    }

}

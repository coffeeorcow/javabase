package com.yi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求 杨辉三角 第 n 行数组
 */
public class Question0119 {

    public static List<Integer> getRows(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        Integer cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            list.add(cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return list;
    }

    public static List<Integer> getRows2(int rowNumber) {
        if (rowNumber < 0) {
            return new ArrayList<>();
        }
        Integer[] list = new Integer[rowNumber + 1];
        Arrays.fill(list, 1);

        for (int i = 0; i <= rowNumber; i++) {
            for (int j = i - 1; j >= 1; j--) {
                list[j] = list[j] + list[j - 1];
            }
        }

        return Arrays.asList(list);
    }

    public static void main(String[] args) {
        System.out.println(getRows(5).toString());
        System.out.println(getRows2(6).toString());
    }

}

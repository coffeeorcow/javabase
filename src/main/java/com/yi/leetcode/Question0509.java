package com.yi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 求斐波那契数列
 */
public class Question0509 {
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int fib(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        int r;
        if (N < 2) {
            r = N;
        } else {
            r = fib(N - 2) + fib(N - 1);
        }
        cache.put(N, r);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}

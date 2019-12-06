package com.yi.leetcode;

/**
 * 求 x^n
 */
public class Question0050 {

    public static double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        return fastPow(x, n);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2, -10));
    }

}

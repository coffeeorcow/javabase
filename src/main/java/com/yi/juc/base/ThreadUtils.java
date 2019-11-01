package com.yi.juc.base;

public class ThreadUtils {

	public static final String START = "开始执行";
	public static final String END = "执行结束";

	public static void print(String msg) {
		System.out.println(Thread.currentThread().getName() + msg);
	}

}

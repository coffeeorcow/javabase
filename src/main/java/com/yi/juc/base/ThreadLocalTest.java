package com.yi.juc.base;

public class ThreadLocalTest {

	private static ThreadLocal<String> resource = new ThreadLocal<>();

	private static void print() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ":" + resource.get());
		resource.remove();
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			resource.set("resource1.");
			print();
			System.out.println("resource removed after:" + resource.get());
		}, "thread1");
		Thread thread2 = new Thread(() -> {
			resource.set("resource2.");
			print();
			System.out.println("resource removed after:" + resource.get());
		}, "thread2");
		thread1.start();
		thread2.start();
	}

}

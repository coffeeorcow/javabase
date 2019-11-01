package com.yi.juc.util;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCount {

	private static AtomicLong count = new AtomicLong();

	// 数据源
	private static Integer[] array1 = new Integer[]{0, 1, 3, 132, 421, 321, 0, 31, 3, 0};
	private static Integer[] array2 = new Integer[]{0, 12, 0, 132, 0, 321, 0, 31, 3, 0};

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			for (Integer i : array1) {
				if (i == 0) {
					count.incrementAndGet();
				}
			}
		});
		Thread thread2 = new Thread(() -> {
			for (Integer i : array2) {
				if (i == 0) {
					count.incrementAndGet();
				}
			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println(count.get());
	}

}

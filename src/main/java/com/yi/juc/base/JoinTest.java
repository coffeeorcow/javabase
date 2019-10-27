package com.yi.juc.base;

public class JoinTest {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			System.out.println("thread1 is running ...");
			for (; ; ) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		final Thread main = Thread.currentThread();

		Thread thread2 = new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			thread1.interrupt();
//			main.interrupt();
		});

		thread1.start();
		thread2.start();

		thread1.join();

	}

}

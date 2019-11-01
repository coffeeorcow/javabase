package com.yi.juc.base;

public class InterrupteTest {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			while (!Thread.currentThread().interrupted()) {

			}
			System.out.println("线程中断结束...");
//			while (true) {
//
//			}
		});

		thread1.start();

		thread1.interrupt();

		System.out.println("isInterrupt: " + thread1.isInterrupted());
		System.out.println("isInterrupted: " + thread1.interrupted());

		System.out.println("isInterrupted: " + Thread.interrupted());
		System.out.println("isInterrupted: " + thread1.isInterrupted());
		System.out.println("isInterrupted: " + thread1.interrupted());
		System.out.println("isAlive: " + thread1.isAlive());

		thread1.join();

		System.out.println("isInterrupted: " + thread1.interrupted());
		System.out.println("isInterrupt: " + thread1.isInterrupted());
		System.out.println("isAlive: " + thread1.isAlive());

	}

}

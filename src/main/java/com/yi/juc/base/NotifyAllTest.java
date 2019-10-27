package com.yi.juc.base;

public class NotifyAllTest {

	private static Object resourceA = new Object();

	private static class MyThread implements Runnable {

		@Override
		public void run() {
			synchronized (resourceA) {
				try {
					System.out.println(Thread.currentThread().getName() + "开始阻塞");
					resourceA.wait();
					System.out.println(Thread.currentThread().getName() + "停止阻塞");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(new MyThread(), "threadA");
		Thread threadB = new Thread(new MyThread(), "threadB");
		Thread threadC = new Thread(() -> {
			synchronized (resourceA) {
				System.out.println("唤醒");
				resourceA.notifyAll();
			}
		}, "threadC");

		threadA.start();
		threadB.start();

		Thread.sleep(1000);

		threadC.start();

	}

}

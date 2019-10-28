package com.yi.juc.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SleepTest {

	private static final Lock lock = new ReentrantLock();

	private static class MyThread implements Runnable{
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " 获取锁");
			lock.lock();
			try {
				System.out.println(threadName + " is in sleep");

				Thread.sleep(2000);

				System.out.println(threadName + " is in awaked");

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " 释放锁");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
			System.out.println(threadName + "运行结束");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new MyThread(), "thread1");
		Thread thread2 = new Thread(new MyThread(), "thread2");

		thread1.start();
		thread2.start();

		thread1.interrupt();

		Thread.interrupted();
		Thread.sleep(2000);
		System.out.println(thread1.isInterrupted());
	}

}

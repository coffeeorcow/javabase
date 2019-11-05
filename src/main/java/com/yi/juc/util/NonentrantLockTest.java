package com.yi.juc.util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

public class NonentrantLockTest {

	final static NonentrantLock lock = new NonentrantLock();
	final static Condition notFull = lock.newCondition();
	final static Condition notEmpty = lock.newCondition();

	final static Queue<String> queue = new LinkedBlockingQueue<>();
	final static int queueSize = 10;

	static long consumeCount = 0;
	static long produceCount = 0;

	static class Producer extends Thread {
		final String threadName;

		Producer(String threadName) {
			super(threadName);
			this.threadName = threadName;
		}

		@Override
		public void run() {
			lock.lock();
			try {
				while (queue.size() == queueSize) {
					notEmpty.await();
				}

				queue.add("ele");
				System.out.println(threadName + " produce: " + produceCount++);

				notFull.signalAll();

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	static class Consumer extends Thread {
		final String threadName;

		Consumer(String threadName) {
			super(threadName);
			this.threadName = threadName;
		}

		@Override
		public void run() {
			lock.lock();
			try {
				while (queue.size() == 0) {
					notFull.await();
				}

				queue.poll();
				System.out.println(threadName + " consume: " + consumeCount++);

				notEmpty.signalAll();

			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		// 2个生产者，5个消费者
		for (int i = 0; i < 2; i++) {
			new Producer("producer" + (i+1)).start();
		}
		for (int i = 0; i < 5; i++) {
			new Consumer("consumer" + (i+1)).start();
		}

	}

}

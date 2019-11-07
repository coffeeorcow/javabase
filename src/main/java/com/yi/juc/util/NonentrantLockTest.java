package com.yi.juc.util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;

public class NonentrantLockTest {

	final static NonentrantLock lock = new NonentrantLock();
	final static Condition notFull = lock.newCondition();
	final static Condition notEmpty = lock.newCondition();

	final static Queue<String> queue = new LinkedBlockingQueue<>();
	final static int queueSize = 10;
	final static int totalNum = 1000;

	static AtomicLong consumeCount = new AtomicLong(0);
	static AtomicLong produceCount = new AtomicLong(0);

	static class Producer extends Thread {
		final String threadName;

		Producer(String threadName) {
			super(threadName);
			this.threadName = threadName;
		}

		@Override
		public void run() {
			while (produceCount.get() < totalNum) {
				lock.lock();
				try {
					// 可能会出现虚假唤醒
					if (queue.size() == queueSize) {
						notEmpty.await();
					}

					queue.add("ele");
					System.out.println(threadName + " produce: " + produceCount.incrementAndGet());

					notFull.signalAll();


				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
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
			while (consumeCount.get() < totalNum) {
				lock.lock();
				try {
					// 可能会出现虚假唤醒
					if (queue.size() == 0) {
						notFull.await();
					}

					queue.poll();
					System.out.println(threadName + " consume: " + consumeCount.incrementAndGet());

					notEmpty.signalAll();

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}

	public static void main(String[] args) {
		// 2个生产者，5个消费者
		for (int i = 0; i < 2; i++) {
			new Producer("producer" + i).start();
		}
		for (int i = 0; i < 5; i++) {
			new Consumer("consumer" + i).start();
		}

	}

}

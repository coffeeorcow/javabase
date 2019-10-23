package com.yi.juc.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class BaseTest {

	public static void main(String[] args) {
		ThreadUtils.print(ThreadUtils.START);

		// 继承方式
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();

		// 接口实现方式
		Thread thread3 = new Thread(new MyRunnable());

		// Callabel 方式
		FutureTask<Integer> future = new FutureTask<>(new MyClallable());
		Thread thread4 = new Thread(future);

		thread4.start();
		try {
			ThreadUtils.print("获取到子线程的返回值为: " + future.get());
		} catch (InterruptedException e) {
			System.out.println("线程中断异常");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("线程执行异常");
			e.printStackTrace();
		}

		thread1.start();
		thread2.start();

		thread3.start();

		ThreadUtils.print(ThreadUtils.END);
	}
}

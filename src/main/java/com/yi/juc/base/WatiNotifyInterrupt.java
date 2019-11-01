package com.yi.juc.base;

public class WatiNotifyInterrupt {

	static Object obj = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			System.out.println("----begin----");
			synchronized (obj) {
				try {
					obj.wait(100);
					System.out.println("----end----");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread.start();

		Thread.sleep(2000);

		System.out.println("interrupt start");
		thread.interrupt();
		System.out.println("interrupt end");
	}

}

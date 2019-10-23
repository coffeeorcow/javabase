package com.yi.juc.base;

public class MyThread extends Thread {

	@Override
	public void run() {
		ThreadUtils.print(ThreadUtils.START);
		ThreadUtils.print(ThreadUtils.END);
	}

}

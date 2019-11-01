package com.yi.juc.base;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		ThreadUtils.print(ThreadUtils.START);
		ThreadUtils.print(ThreadUtils.END);
	}

}

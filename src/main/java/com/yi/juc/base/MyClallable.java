package com.yi.juc.base;

import java.util.concurrent.Callable;

public class MyClallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		ThreadUtils.print(ThreadUtils.START);
		ThreadUtils.print(ThreadUtils.END);
		return 1;
	}

}

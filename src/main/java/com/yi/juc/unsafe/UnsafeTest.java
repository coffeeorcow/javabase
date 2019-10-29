package com.yi.juc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

	static Unsafe unsafe = null;

	static long stateOffset = 0;

	private volatile long state = 0;

	static {
		try {
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);
			stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			throw new Error(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UnsafeTest test = new UnsafeTest();
		Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
		System.out.println(success);
	}

}

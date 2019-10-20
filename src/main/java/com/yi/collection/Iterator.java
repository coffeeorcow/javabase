package com.yi.collection;

public interface Iterator<E> {

	/**
	 * 是否还有元素
	 * @return  0 - 是 1 - 否
	 */
	boolean hasNext();

	/**
	 * 返回下一个遍历的对象
	 * @return  下一个对象
	 */
	E next();

	/**
	 * 移除当前对象
	 * @return  移除个数
	 */
	int remove();
}

package com.yi.collection;

public interface Collection<E> extends Iterable<E>{

	/**
	 * 向集合中添加元素
	 * @return      添加个数
	 */
	boolean add(E e);

	/**
	 * 查看集合的大小
	 * @return      集合的大小
	 */
	int size();

	/**
	 * 判断集合是否为空
	 * @return      0 - 集合为空 1 - 集合不为空
	 */
	boolean isEmpty();

	/**
	 * 判断某个元素是否在集合中
	 * @param obj       需要判断的树
	 * @return          true - 包含 false - 不包含
	 */
	boolean contain(Object obj);

	/**
	 * 清空集合
	 */
	void clear();

	/**
	 * 将集合转换为数组
	 * @return 数组对象
	 */
	Object[] toArray();

}

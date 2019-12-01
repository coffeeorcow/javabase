package com.yi.collection.list;

import com.yi.collection.Iterator;

public class ArrayList<E> implements List<E> {

	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENT_DATA = {};
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	private Object[] items;
	private int size;

	public ArrayList() {
		items = EMPTY_ELEMENT_DATA;
	}

	public ArrayList(int initialCapacity) {
		if (initialCapacity > 0) {
			items = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			items = EMPTY_ELEMENT_DATA;
		} else {
			throw new IllegalArgumentException("列表大小不合规: " + initialCapacity);
		}
	}

	@Override
	public boolean add(E e) {
		ensureCapacityInternal(size + 1);
		items[size++] = e;
		return true;
	}

	private void ensureCapacityInternal(int minCapacity) {
		if (minCapacity - items.length > 0) {
			grow(minCapacity);
		}
	}

	private void grow(int minCapacity) {
		int oldSize = items.length;
		int newCapacity = oldSize + (oldSize >> 1);
		if (newCapacity - minCapacity < 0) {
			newCapacity = minCapacity;
		}
		if (newCapacity - MAX_ARRAY_SIZE > 0) {
			newCapacity = hugeCapacity(minCapacity);
		}

		items = Arrays.copyOf(items, newCapacity);
	}

	private int hugeCapacity(int minCapacity) {
		if (minCapacity < 0) {
			throw new OutOfMemoryError("array size is too big");
		}
		return minCapacity - MAX_ARRAY_SIZE < 0 ?
				MAX_ARRAY_SIZE :
				Integer.MAX_VALUE;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contain(Object obj) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list.toString());
	}
}

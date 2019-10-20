package com.yi.collection;

import com.sun.istack.internal.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

public interface Iterable<T> {

	@NotNull Iterator<T> iterator();

	default void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);
		// todo: 此处报错，参考源码
		/*for (T t : this) {
			action.accept(t);
		}*/
	}

}

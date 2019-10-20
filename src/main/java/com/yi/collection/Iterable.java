package com.yi.collection;

import com.sun.istack.internal.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

public interface Iterable<T> {

	@NotNull Iterator<T> iterator();

	default void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);
		Iterator<T> var = this.iterator();

		while (var.hasNext()) {
			T t = var.next();
			action.accept(t);
		}
	}

}
